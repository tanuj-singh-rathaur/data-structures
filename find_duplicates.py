"""
Find true duplicate Java stubs: two different filenames in the same folder
that point to the same LeetCode problem URL.
"""
import re
from pathlib import Path
from collections import defaultdict

SRC = Path(r"C:\Projects\DSA\DSA_project\src")
LC_URL_RE = re.compile(r"https?://leetcode\.com/problems/([\w-]+)/?")
LC_NUM_RE = re.compile(r"LeetCode\s*#(\d+)", re.IGNORECASE)

# folder -> {key -> set(files)} where key is the LC slug or 'LC#<num>'
by_folder = defaultdict(lambda: defaultdict(set))

for jf in SRC.rglob("*.java"):
    text = jf.read_text(encoding="utf-8", errors="replace")
    # Collect unique problem identifiers in this file
    keys = set()
    for m in LC_URL_RE.finditer(text):
        keys.add(("slug", m.group(1).rstrip("-")))
    for m in LC_NUM_RE.finditer(text):
        keys.add(("num", m.group(1)))
    folder = str(jf.parent.relative_to(SRC.parent))
    for k in keys:
        by_folder[folder][k].add(jf.name)

# Also pair slugs to numbers for kadane case where the two stub styles
# don't share a key. Use a global slug->num and num->slug join.
SLUG_TO_NUM = {
    "maximum-subarray": "53",
    "maximum-product-subarray": "152",
    "best-time-to-buy-and-sell-stock": "121",
    "maximum-sum-circular-subarray": "918",
    "maximum-absolute-sum-of-any-subarray": "1749",
    "longest-turbulent-subarray": "978",
    "jump-game": "55",
    "jump-game-ii": "45",
    "maximum-subarray-sum-with-one-deletion": "1186",
    "two-sum-ii-input-array-is-sorted": "167",
    "3sum": "15",
    "container-with-most-water": "11",
    "trapping-rain-water": "42",
}

print("="*70)
print("TRUE DUPLICATES (different files, same LeetCode problem, same folder)")
print("="*70)
total_dups = 0
for folder, key_map in sorted(by_folder.items()):
    # Merge slug + num keys that refer to the same problem
    merged = defaultdict(set)
    for (kind, val), files in key_map.items():
        if kind == "slug":
            num = SLUG_TO_NUM.get(val, val)
            merged[num] |= files
        else:
            merged[val] |= files

    for problem_key, files in merged.items():
        if len(files) > 1:
            total_dups += 1
            print(f"\n  {folder}   (LC#{problem_key})")
            for f in sorted(files):
                print(f"      - {f}")

if total_dups == 0:
    print("\n  (no true duplicates detected)")
else:
    print(f"\n{total_dups} duplicate group(s) total")
