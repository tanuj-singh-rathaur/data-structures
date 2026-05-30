"""Remove duplicate consecutive `package X.Y.Z;` lines in .java files."""
import re
from pathlib import Path

SRC = Path(r"C:\Projects\DSA\DSA_project\src")
PKG_LINE_RE = re.compile(r"^package\s+[\w.]+\s*;\s*$", re.MULTILINE)

fixed = []
for jf in SRC.rglob("*.java"):
    text = jf.read_text(encoding="utf-8", errors="replace")
    pkg_lines = PKG_LINE_RE.findall(text)
    if len(pkg_lines) > 1:
        # Keep only the first occurrence
        first = pkg_lines[0]
        # Remove all matches, then place the first one back at top
        new_text = PKG_LINE_RE.sub("", text)
        # Strip leading blank lines
        new_text = new_text.lstrip("\r\n")
        new_text = first + "\n\n" + new_text
        jf.write_text(new_text, encoding="utf-8")
        fixed.append(str(jf.relative_to(SRC.parent)))

print(f"De-duplicated package in {len(fixed)} files")
for p in fixed[:25]:
    print(f"  {p}")
if len(fixed) > 25:
    print(f"  ... and {len(fixed) - 25} more")
