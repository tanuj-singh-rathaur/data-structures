"""Strip UTF-8 BOM from all .java files under src/."""
from pathlib import Path

SRC = Path(r"C:\Projects\DSA\DSA_project\src")
BOM = "﻿"

stripped = []
for jf in SRC.rglob("*.java"):
    raw = jf.read_bytes()
    text = raw.decode("utf-8-sig" if raw.startswith(b"\xef\xbb\xbf") else "utf-8", errors="replace")
    # Also strip any BOM that appears NOT at the very start (e.g., mid-file from concatenation)
    if BOM in text:
        text = text.replace(BOM, "")
        jf.write_text(text, encoding="utf-8")
        stripped.append(str(jf.relative_to(SRC.parent)))
    elif raw.startswith(b"\xef\xbb\xbf"):
        # File had BOM at start; utf-8-sig decode already stripped it, but we still need to rewrite
        jf.write_text(text, encoding="utf-8")
        stripped.append(str(jf.relative_to(SRC.parent)))

print(f"Stripped BOM from {len(stripped)} files")
for p in stripped[:20]:
    print(f"  {p}")
if len(stripped) > 20:
    print(f"  ... and {len(stripped) - 20} more")
