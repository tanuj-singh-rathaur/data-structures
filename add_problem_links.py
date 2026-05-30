"""
Patch a Masterclass HTML so each row in the Problem Index links to the
corresponding P##_Name.html file in the same folder.

Currently scoped to: src/arrays/twopointer/00_Masterclass.html
"""
import re
from pathlib import Path

FOLDER = Path(r"C:\Projects\DSA\DSA_project\src\arrays\twopointer")
MASTER = FOLDER / "00_Masterclass.html"

# Build {P01: 'P01_TwoSumII.html', ...} from the actual files on disk
problem_files = {}
for f in FOLDER.glob("P*.html"):
    m = re.match(r"(P\d+)_", f.name)
    if m:
        problem_files[m.group(1)] = f.name

print(f"Discovered {len(problem_files)} problem HTMLs")

text = MASTER.read_text(encoding="utf-8")
original = text

# Pattern matches rows like:
# <tr [optional bg]><td style="padding:7px">P01</td><td style="padding:7px">Two Sum II</td>...
# We rewrite the first two <td>s to be wrapped in <a href>.
ROW_RE = re.compile(
    r'(<tr[^>]*>)'                                    # opening <tr>
    r'(<td style="padding:7px">)(P\d+)(</td>)'        # ID cell
    r'(<td style="padding:7px">)([^<]+)(</td>)'       # Name cell
)

def rewrite(m):
    tr_open, id_open, pid, id_close, name_open, name, name_close = m.groups()
    href = problem_files.get(pid)
    if not href:
        return m.group(0)              # leave as-is if no file
    # Skip if already linked
    if 'href=' in m.group(0):
        return m.group(0)
    return (f'{tr_open}'
            f'{id_open}<a href="{href}" style="color:#2563eb;text-decoration:none">{pid}</a>{id_close}'
            f'{name_open}<a href="{href}" style="color:#2563eb;text-decoration:none">{name}</a>{name_close}')

new_text, n = ROW_RE.subn(rewrite, text)
print(f"Rewrote {n} rows")

if new_text != original:
    MASTER.write_text(new_text, encoding="utf-8")
    print(f"Saved {MASTER.relative_to(MASTER.parents[3])}")
else:
    print("No changes (already linked or no rows matched)")
