"""
Fix Java compile errors across DSA_project/src:
  1. Add missing `package X.Y.Z;` line at top of file
  2. Rename `public class OldName` to `public class <FilenameStem>`
     (and update constructor calls in main())

Safe to re-run: skips files that already have correct package + class name.
Also reports likely-duplicate files (same LeetCode URL in same folder).
"""

import os
import re
from pathlib import Path
from collections import defaultdict

SRC = Path(r"C:\Projects\DSA\DSA_project\src")

PACKAGE_RE = re.compile(r"^\s*package\s+([\w.]+)\s*;", re.MULTILINE)
CLASS_RE   = re.compile(r"(public\s+class\s+)(\w+)")
LC_URL_RE  = re.compile(r"https?://leetcode\.com/problems/[\w-]+/?")

changes = []
already_ok = []
errors = []
lc_url_by_folder = defaultdict(list)   # folder -> [(url, file)]

for java_file in SRC.rglob("*.java"):
    rel_to_src = java_file.relative_to(SRC)
    parent_parts = rel_to_src.parent.parts                  # e.g. ('arrays', 'kadane')
    expected_pkg = ".".join(parent_parts) if parent_parts else None
    expected_class = java_file.stem                          # e.g. 'P01_Maximum_Subarray'

    try:
        src = java_file.read_text(encoding="utf-8")
    except Exception as e:
        errors.append((str(java_file), f"read failed: {e}"))
        continue

    original = src
    file_changes = []

    # --- 1. Fix / add package declaration ---
    pkg_match = PACKAGE_RE.search(src)
    if expected_pkg:
        if pkg_match:
            if pkg_match.group(1) != expected_pkg:
                src = src[:pkg_match.start()] + f"package {expected_pkg};" + src[pkg_match.end():]
                file_changes.append(f"package: {pkg_match.group(1)} -> {expected_pkg}")
        else:
            # Insert package line at the very top
            src = f"package {expected_pkg};\n\n" + src
            file_changes.append(f"package: added {expected_pkg}")

    # --- 2. Rename public class to match filename ---
    cls_match = CLASS_RE.search(src)
    if cls_match:
        old_name = cls_match.group(2)
        if old_name != expected_class:
            # Replace whole-word occurrences of old_name with expected_class
            src = re.sub(rf"\b{re.escape(old_name)}\b", expected_class, src)
            file_changes.append(f"class: {old_name} -> {expected_class}")
    else:
        errors.append((str(java_file), "no `public class` found"))

    # --- 3. Track LeetCode URLs for duplicate detection ---
    for url in LC_URL_RE.findall(src):
        folder = str(java_file.parent)
        lc_url_by_folder[(folder, url.rstrip("/"))].append(java_file.name)

    # --- 4. Write back if changed ---
    if src != original:
        java_file.write_text(src, encoding="utf-8")
        changes.append((str(java_file.relative_to(SRC.parent)), file_changes))
    else:
        already_ok.append(str(java_file.relative_to(SRC.parent)))


# --- Report ---
print(f"\n{'='*70}")
print(f"FIXED {len(changes)} files / {len(already_ok)} were already OK / {len(errors)} errors")
print('='*70)

if changes:
    print(f"\n--- Sample of fixes (first 15) ---")
    for path, chs in changes[:15]:
        print(f"  {path}")
        for c in chs:
            print(f"      - {c}")
    if len(changes) > 15:
        print(f"  ... and {len(changes) - 15} more")

if errors:
    print(f"\n--- ERRORS ({len(errors)}) ---")
    for path, msg in errors:
        print(f"  {path}: {msg}")

# Duplicates: same folder + same LeetCode URL
print(f"\n{'='*70}")
print("LIKELY DUPLICATES (same folder + same LeetCode URL)")
print('='*70)
dup_count = 0
for (folder, url), files in lc_url_by_folder.items():
    if len(files) > 1:
        dup_count += 1
        rel_folder = str(Path(folder).relative_to(SRC.parent))
        print(f"\n  {rel_folder}   ({url})")
        for f in files:
            print(f"      - {f}")
if dup_count == 0:
    print("  (none detected by URL)")

print()
