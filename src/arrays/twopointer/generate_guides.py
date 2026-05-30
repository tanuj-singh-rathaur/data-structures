#!/usr/bin/env python3
"""
Two Pointer Study Guide Generator
Generates one HTML study-guide PDF per problem + a master overview.
Run:  python generate_guides.py
Output: same folder — *.html files (open in browser, Ctrl+P -> Save as PDF)
"""

import os, textwrap

# ──────────────────────────────────────────────────────────────
#  CSS  (A4-optimised, print-friendly)
# ──────────────────────────────────────────────────────────────
CSS = """
*{box-sizing:border-box;margin:0;padding:0}
body{font-family:'Segoe UI',Arial,sans-serif;background:#f8fafc;color:#1e293b;font-size:15px;line-height:1.65}
.page{max-width:860px;margin:0 auto;padding:32px 40px}
h1{font-size:1.8rem;font-weight:700;margin-bottom:4px}
h2{font-size:1.1rem;font-weight:600;margin:28px 0 10px;padding-left:10px;border-left:4px solid #2563eb;color:#1e40af}
h3{font-size:.95rem;font-weight:600;color:#475569;margin:18px 0 6px}
p{margin-bottom:10px}
.badge{display:inline-block;padding:3px 12px;border-radius:99px;font-size:.78rem;font-weight:700;letter-spacing:.5px}
.easy{background:#dcfce7;color:#15803d}
.medium{background:#fef9c3;color:#a16207}
.hard{background:#fee2e2;color:#b91c1c}
.meta{display:flex;align-items:center;gap:12px;margin-bottom:24px;color:#64748b;font-size:.88rem}
.lc-link{color:#2563eb;text-decoration:none;font-weight:600}
.section{background:#fff;border:1px solid #e2e8f0;border-radius:10px;padding:20px 24px;margin-bottom:18px}
.section.blue{border-left:4px solid #2563eb}
.section.green{border-left:4px solid #16a34a}
.section.orange{border-left:4px solid #d97706}
.section.purple{border-left:4px solid #7c3aed}
.section.red{border-left:4px solid #dc2626}
pre{background:#0f172a;color:#e2e8f0;padding:18px 20px;border-radius:8px;overflow-x:auto;font-family:'Consolas','Courier New',monospace;font-size:.82rem;line-height:1.6;margin:10px 0}
.type-card{border-radius:10px;padding:22px 24px;margin:22px 0;border:1px solid #e2e8f0;border-left:6px solid #2563eb}
.t1{border-left-color:#2563eb;background:#f0f7ff}
.t2{border-left-color:#16a34a;background:#f0fdf4}
.t3{border-left-color:#d97706;background:#fffbeb}
.t4{border-left-color:#7c3aed;background:#faf5ff}
.t5{border-left-color:#dc2626;background:#fff5f5}
.type-title{font-size:1.05rem;font-weight:700;margin-bottom:14px;padding-bottom:8px;border-bottom:1px solid rgba(0,0,0,.07)}
.t1 .type-title{color:#1d4ed8}.t2 .type-title{color:#15803d}.t3 .type-title{color:#b45309}.t4 .type-title{color:#6d28d9}.t5 .type-title{color:#b91c1c}
.rule-box{background:rgba(255,255,255,.7);border-radius:8px;padding:12px 16px;margin:10px 0}
.rule-box ul,.rule-box ol{padding-left:20px;margin:4px 0}.rule-box li{margin-bottom:5px}
.walk{background:#0f172a;border-radius:8px;overflow:hidden;margin:12px 0}
.walk-title{background:#1e293b;color:#94a3b8;padding:7px 16px;font-size:.78rem;letter-spacing:.5px;text-transform:uppercase;font-family:'Consolas','Courier New',monospace}
.wstep{display:flex;align-items:flex-start;gap:16px;border-bottom:1px solid #1e293b;padding:10px 16px}
.wstep:last-child{border-bottom:none}
.wstep-n{min-width:58px;color:#fbbf24;font-weight:700;font-family:'Consolas','Courier New',monospace;font-size:.81rem;padding-top:8px;flex-shrink:0}
.wstep-act{color:#6ee7b7;font-size:.78rem;font-family:'Consolas','Courier New',monospace;padding-top:8px;line-height:1.7;flex:1}
.arow{display:flex;align-items:flex-end;gap:2px;margin:4px 0}
.abk{color:#64748b;font-family:'Consolas','Courier New',monospace;font-size:.9rem;padding:0 2px;line-height:1;padding-bottom:20px}
.ac{display:inline-flex;flex-direction:column;align-items:center;min-width:38px;background:#1e293b;border:1px solid #334155;border-radius:4px;padding:5px 4px 3px;font-family:'Consolas','Courier New',monospace;font-size:.82rem;color:#e2e8f0;font-weight:600}
.ac.aL{background:#172554;border-color:#3b82f6;color:#93c5fd}
.ac.aR{background:#450a0a;border-color:#ef4444;color:#fca5a5}
.ac.aS{background:#052e16;border-color:#22c55e;color:#86efac}
.ac.aF{background:#431407;border-color:#f97316;color:#fdba74}
.ac.ai{background:#2e1065;border-color:#a855f7;color:#d8b4fe}
.ac.aH{background:#1e1b4b;border-color:#818cf8;color:#c7d2fe}
.ac.aW{background:#14291e;border-color:#4ade80;color:#4ade80}
.pl{font-size:.7rem;font-weight:700;min-height:13px;margin-top:3px;line-height:1}
.pL{color:#60a5fa}.pR{color:#f87171}
.pS{color:#34d399}.pF{color:#fb923c}
.pi{color:#d8b4fe}.pH{color:#c7d2fe}
.L{color:#60a5fa;font-weight:700}.R{color:#f87171;font-weight:700}
.S{color:#34d399;font-weight:700}.F{color:#fb923c;font-weight:700}
.i{color:#e879f9;font-weight:700}.M{color:#a78bfa;font-weight:700}
.found{color:#fcd34d;font-weight:700}
.prob-tags{display:flex;flex-wrap:wrap;gap:7px;margin-top:10px}
.prob-tag{border-radius:6px;padding:3px 10px;font-size:.8rem;font-weight:600}
.t1 .prob-tag{background:#dbeafe;color:#1d4ed8}.t2 .prob-tag{background:#dcfce7;color:#15803d}
.t3 .prob-tag{background:#fef3c7;color:#b45309}.t4 .prob-tag{background:#ede9fe;color:#6d28d9}
.t5 .prob-tag{background:#fee2e2;color:#b91c1c}
.diagram{background:#1e293b;color:#94a3b8;padding:16px 20px;border-radius:8px;font-family:'Consolas','Courier New',monospace;font-size:.82rem;line-height:1.8;margin:10px 0;white-space:pre}
.steps ol{padding-left:22px}
.steps li{margin-bottom:8px}
.kv{display:flex;gap:16px;flex-wrap:wrap}
.kv-item{background:#f1f5f9;border-radius:6px;padding:8px 14px;flex:1;min-width:160px}
.kv-label{font-size:.75rem;color:#64748b;font-weight:600;text-transform:uppercase;letter-spacing:.5px}
.kv-val{font-size:.92rem;font-weight:600;color:#1e293b;margin-top:2px}
.insight{background:#eff6ff;border:1px solid #bfdbfe;border-radius:8px;padding:14px 18px;margin-top:8px}
.insight strong{color:#1d4ed8}
.pattern-box{background:#faf5ff;border:1px solid #ddd6fe;border-radius:8px;padding:14px 18px}
.pattern-box strong{color:#6d28d9}
.comment{color:#6ee7b7}
.kw{color:#93c5fd}
.str{color:#fca5a5}
.num{color:#fcd34d}
.divider{border:none;border-top:2px solid #e2e8f0;margin:28px 0}
header{padding-bottom:20px;border-bottom:2px solid #e2e8f0;margin-bottom:24px}
.footer{text-align:center;color:#94a3b8;font-size:.8rem;margin-top:32px;padding-top:16px;border-top:1px solid #e2e8f0}
@media print{
  body{background:#fff}
  .page{padding:20px}
  .section{break-inside:avoid}
  pre,code{break-inside:avoid}
  header{break-after:avoid}
  h2{break-after:avoid}
}
"""

# ──────────────────────────────────────────────────────────────
#  HTML page builder
# ──────────────────────────────────────────────────────────────
def make_page(title, body_html, extra_head=""):
    return f"""<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>{title}</title>
<style>{CSS}</style>
{extra_head}
</head>
<body>
<div class="page">
{body_html}
<div class="footer">Two Pointer Masterclass &mdash; DSA Practice Series</div>
</div>
</body>
</html>"""

def section(color, heading, html_body):
    return f'<div class="section {color}"><h2>{heading}</h2>{html_body}</div>'

def diagram(text):
    return f'<div class="diagram">{text}</div>'

def steps(items):
    li = "".join(f"<li>{s}</li>" for s in items)
    return f'<div class="steps"><ol>{li}</ol></div>'

def code(java):
    return f"<pre>{java}</pre>"

def kv(pairs):
    items = "".join(f'<div class="kv-item"><div class="kv-label">{k}</div><div class="kv-val">{v}</div></div>' for k,v in pairs)
    return f'<div class="kv">{items}</div>'

def insight(text):
    return f'<div class="insight"><strong>Key Insight:</strong> {text}</div>'

def pattern_box(text):
    return f'<div class="pattern-box"><strong>Two Pointer Pattern:</strong> {text}</div>'


# ──────────────────────────────────────────────────────────────
#  MASTER OVERVIEW  (00_Masterclass.html)
# ──────────────────────────────────────────────────────────────
def generate_master():
    body = """
<header>
  <h1>Two Pointer Technique &mdash; Complete Masterclass</h1>
  <div class="meta">Arrays &rsaquo; Two Pointer &nbsp;&bull;&nbsp; 20 Problems Covered</div>
</header>

<div class="section blue">
<h2>&#128161; What Is Two Pointer? (Layman's Explanation)</h2>
<p>Imagine you're in a <strong>sorted lineup of people by height</strong> and you want to find two people whose combined height is exactly 180 cm. The <em>dumb way</em> is to pair everyone with everyone else &mdash; that's O(n&sup2;). The <em>smart way</em>:</p>
<ol style="padding-left:22px;margin:10px 0">
  <li>Put your left hand on the <strong>shortest</strong> person (far left).</li>
  <li>Put your right hand on the <strong>tallest</strong> person (far right).</li>
  <li>Check their sum:<br>
    &nbsp;&nbsp;&bull; <strong>Too tall?</strong> Move your right hand left (we need someone shorter).<br>
    &nbsp;&nbsp;&bull; <strong>Too short?</strong> Move your left hand right (we need someone taller).<br>
    &nbsp;&nbsp;&bull; <strong>Exact match?</strong> Done!
  </li>
</ol>
<p>Each step eliminates an <em>entire row of possibilities</em>. That's why it's O(n) instead of O(n&sup2;). The secret weapon: <strong>the array is sorted</strong>, so moving a pointer in one direction always makes the sum go in a predictable direction.</p>
</div>

<div class="section green">
<h2>&#128270; When Should You Use Two Pointer?</h2>
<p>Look for these signals in the problem:</p>
<ul style="padding-left:22px;margin:10px 0">
  <li>The array is <strong>sorted</strong> (or you can sort it).</li>
  <li>You're looking for a <strong>pair/triplet/k-tuple</strong> that meets some condition.</li>
  <li>The problem says <strong>O(1) extra space</strong>.</li>
  <li>You need to <strong>remove elements in-place</strong>.</li>
  <li>You need to <strong>check/reverse from both ends</strong> (palindrome, reverse).</li>
  <li>The brute force is O(n&sup2;) and you know there must be a better way.</li>
</ul>
</div>

<div class="section orange">
<h2>&#128200; The 5 Types of Two Pointer &mdash; Full Breakdown</h2>

<!-- ═══════════════════════════════════════════════════
     TYPE 1 — OPPOSITE ENDS
════════════════════════════════════════════════════ -->
<div class="type-card t1">
<div class="type-title">&#9312; Opposite Ends &nbsp;(Converging)</div>

<div class="rule-box">
<p><strong>What it is:</strong> One pointer starts at the <strong>left end</strong>, one at the <strong>right end</strong>. They march toward each other. Each step you look at both values and decide which side to move — you never move both at once (unless you found the answer).</p>
<p><strong>Recognize it when:</strong></p>
<ul>
  <li>The array is sorted (or you can sort it)</li>
  <li>You need a pair whose sum / product / area satisfies a condition</li>
  <li>You're checking symmetry from both ends (palindrome, reverse)</li>
  <li>Brute force would be O(n&sup2;) and O(1) space is required</li>
</ul>
<p><strong>The decision rule:</strong></p>
<ul>
  <li>Result too big &rarr; move <span class="R">R</span> left (shrink from the right)</li>
  <li>Result too small &rarr; move <span class="L">L</span> right (grow from the left)</li>
  <li>Exact match &rarr; record answer, move both</li>
</ul>
</div>

<strong>Worked Example: Two Sum II</strong> &mdash; find pair summing to <code>9</code> in <code>[2, 7, 11, 15]</code>

<div class="walk">
<div class="walk-title">Step-by-step trace &nbsp;&mdash;&nbsp; blue cell = L &nbsp;|&nbsp; red cell = R</div>

<div class="wstep">
<span class="wstep-n">Start</span>
<div><div class="arow"><span class="abk">[</span><span class="ac aL">2<span class="pl pL">L</span></span><span class="ac">7<span class="pl">&nbsp;</span></span><span class="ac">11<span class="pl">&nbsp;</span></span><span class="ac aR">15<span class="pl pR">R</span></span><span class="abk">]</span></div></div>
<span class="wstep-act">L=0 (value 2), R=3 (value 15)</span>
</div>

<div class="wstep">
<span class="wstep-n">Step 1</span>
<div><div class="arow"><span class="abk">[</span><span class="ac aL">2<span class="pl pL">L</span></span><span class="ac">7<span class="pl">&nbsp;</span></span><span class="ac">11<span class="pl">&nbsp;</span></span><span class="ac aR">15<span class="pl pR">R</span></span><span class="abk">]</span></div></div>
<span class="wstep-act">sum = 2 + 15 = 17 &gt; 9
&rarr; too big &rarr; R-- (move R left)</span>
</div>

<div class="wstep">
<span class="wstep-n">Step 2</span>
<div><div class="arow"><span class="abk">[</span><span class="ac aL">2<span class="pl pL">L</span></span><span class="ac">7<span class="pl">&nbsp;</span></span><span class="ac aR">11<span class="pl pR">R</span></span><span class="ac">15<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div>
<span class="wstep-act">sum = 2 + 11 = 13 &gt; 9
&rarr; too big &rarr; R-- (move R left)</span>
</div>

<div class="wstep">
<span class="wstep-n">Step 3</span>
<div><div class="arow"><span class="abk">[</span><span class="ac aL">2<span class="pl pL">L</span></span><span class="ac aR">7<span class="pl pR">R</span></span><span class="ac">11<span class="pl">&nbsp;</span></span><span class="ac">15<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div>
<span class="wstep-act">sum = 2 + 7 = 9 = 9
&rarr; FOUND! return [1, 2]</span>
</div>

</div>

<strong>Code Template:</strong>
<pre>int left = 0, right = n - 1;
while (left &lt; right) {
    int val = compute(arr[left], arr[right]);
    if      (val == target) { /* found */ break; }
    else if (val &lt; target)  left++;    // need bigger
    else                    right--;   // need smaller
}</pre>
<div class="prob-tags">
  <span class="prob-tag">P01 Two Sum II</span>
  <span class="prob-tag">P03 Container With Most Water</span>
  <span class="prob-tag">P04 Trapping Rain Water</span>
  <span class="prob-tag">P09 Valid Palindrome</span>
  <span class="prob-tag">P10 Reverse String</span>
  <span class="prob-tag">P13 Boats to Save People</span>
  <span class="prob-tag">P19 Shortest Unsorted Subarray</span>
  <span class="prob-tag">P20 Minimize Max Pair Sum</span>
</div>
</div>


<!-- ═══════════════════════════════════════════════════
     TYPE 2 — SLOW + FAST
════════════════════════════════════════════════════ -->
<div class="type-card t2">
<div class="type-title">&#9313; Slow + Fast &nbsp;(Same Direction)</div>

<div class="rule-box">
<p><strong>What it is:</strong> Both pointers move <strong>left to right</strong>, but at different speeds. <span class="F">Fast</span> is the <em>reader</em> — it visits every element without exception. <span class="S">Slow</span> is the <em>writer</em> — it only advances when fast finds something worth keeping. Everything before <span class="S">slow</span> at the end is your answer.</p>
<p><strong>Recognize it when:</strong></p>
<ul>
  <li>Remove / filter elements in-place without extra space</li>
  <li>"Move all X to the end" or "keep only Y"</li>
  <li>You need to compact an array (skip zeroes, skip duplicates, skip a value)</li>
</ul>
<p><strong>The decision rule:</strong></p>
<ul>
  <li><span class="F">fast</span> always advances every iteration</li>
  <li><span class="S">slow</span> only advances when <span class="F">nums[fast]</span> is a &ldquo;good&rdquo; element</li>
  <li>Write <span class="F">nums[fast]</span> into <span class="S">nums[slow]</span> before advancing <span class="S">slow</span></li>
</ul>
</div>

<strong>Worked Example: Move Zeroes</strong> &mdash; move all zeros to the end in <code>[0, 1, 0, 3, 12]</code>

<div class="walk">
<div class="walk-title">Step-by-step trace &nbsp;&mdash;&nbsp; green cell = S (write head) &nbsp;|&nbsp; orange cell = F (scanner)</div>

<div class="wstep">
<span class="wstep-n">Start</span>
<div><div class="arow"><span class="abk">[</span><span class="ac aS aF">0<span class="pl pS">S/F</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac">12<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div>
<span class="wstep-act">S=0, F=0 &mdash; both start at index 0</span>
</div>

<div class="wstep">
<span class="wstep-n">Step 1</span>
<div><div class="arow"><span class="abk">[</span><span class="ac aF">0<span class="pl pF">F</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac">12<span class="pl">&nbsp;</span></span><span class="abk">]</span></div><div style="font-size:.75rem;color:#64748b;font-family:monospace;margin-top:2px">&nbsp;&nbsp;&nbsp;&nbsp;S is also at index 0 (not moving)</div></div>
<span class="wstep-act">nums[F] = 0 &rarr; BAD (zero)
F++ only &mdash; S stays put</span>
</div>

<div class="wstep">
<span class="wstep-n">Step 2</span>
<div><div class="arow"><span class="abk">[</span><span class="ac aS">1<span class="pl pS">S</span></span><span class="ac aF">1<span class="pl pF">F</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac">12<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div>
<span class="wstep-act">nums[F] = 1 &rarr; GOOD
write nums[S] = 1, then S++, F++
(array[0] is now 1)</span>
</div>

<div class="wstep">
<span class="wstep-n">Step 3</span>
<div><div class="arow"><span class="abk">[</span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac aS">1<span class="pl pS">S</span></span><span class="ac aF">0<span class="pl pF">F</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac">12<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div>
<span class="wstep-act">nums[F] = 0 &rarr; BAD (zero)
F++ only &mdash; S stays put</span>
</div>

<div class="wstep">
<span class="wstep-n">Step 4</span>
<div><div class="arow"><span class="abk">[</span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac aS">3<span class="pl pS">S</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac aF">3<span class="pl pF">F</span></span><span class="ac">12<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div>
<span class="wstep-act">nums[F] = 3 &rarr; GOOD
write nums[S] = 3, then S++, F++</span>
</div>

<div class="wstep">
<span class="wstep-n">Step 5</span>
<div><div class="arow"><span class="abk">[</span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac aS">12<span class="pl pS">S</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac aF">12<span class="pl pF">F</span></span><span class="abk">]</span></div></div>
<span class="wstep-act">nums[F] = 12 &rarr; GOOD
write nums[S] = 12, then S++, F++
(F is now past end &mdash; loop done)</span>
</div>

<div class="wstep">
<span class="wstep-n">Done</span>
<div><div class="arow"><span class="abk">[</span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac">12<span class="pl">&nbsp;</span></span><span class="ac aW">0<span class="pl pS">S</span></span><span class="ac aW">0<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div>
<span class="wstep-act">Fill positions S &rarr; end with zeros
Result: [1, 3, 12, 0, 0]</span>
</div>

</div>

<strong>Code Template:</strong>
<pre>int slow = 0;
for (int fast = 0; fast &lt; n; fast++) {
    if (nums[fast] /* is "good" */) {
        nums[slow++] = nums[fast];
    }
}
// slow = count of good elements</pre>
<div class="prob-tags">
  <span class="prob-tag">P05 Remove Duplicates</span>
  <span class="prob-tag">P07 Move Zeroes</span>
  <span class="prob-tag">P16 Is Subsequence</span>
  <span class="prob-tag">P17 Remove Element</span>
</div>
</div>


<!-- ═══════════════════════════════════════════════════
     TYPE 3 — FIX ONE + TWO POINTER
════════════════════════════════════════════════════ -->
<div class="type-card t3">
<div class="type-title">&#9314; Fix One + Two Pointer &nbsp;(k-Sum Family)</div>

<div class="rule-box">
<p><strong>What it is:</strong> You <strong>lock one element</strong> with an outer loop (<span class="i">i</span>), then run a Type&nbsp;1 (Opposite Ends) two-pointer on <em>the subarray to the right</em>. This turns a 3-variable problem into a 2-variable one you already know how to solve. 4Sum adds one more fixed loop.</p>
<p><strong>Recognize it when:</strong></p>
<ul>
  <li>Find all triplets / quadruplets summing to a target</li>
  <li>Brute force is O(n&sup3;) and you suspect O(n&sup2;) exists</li>
  <li>Duplicates must be avoided in the result</li>
</ul>
<p><strong>The decision rule (inner two-pointer):</strong></p>
<ul>
  <li>sum &lt; target &rarr; <span class="L">L++</span> &nbsp;(need bigger left value)</li>
  <li>sum &gt; target &rarr; <span class="R">R--</span> &nbsp;(need smaller right value)</li>
  <li>sum == 0 &rarr; record, skip duplicate <span class="L">L</span> and <span class="R">R</span> values, then <span class="L">L++</span> <span class="R">R--</span></li>
  <li>After inner loop, skip duplicate <span class="i">i</span> values before next outer iteration</li>
</ul>
</div>

<strong>Worked Example: 3Sum</strong> &mdash; find all triplets summing to <code>0</code> in <code>[-4,&nbsp;-1,&nbsp;-1,&nbsp;0,&nbsp;1,&nbsp;2]</code>

<div class="walk">
<div class="walk-title">Step-by-step trace &nbsp;&mdash;&nbsp; purple = i (fixed) &nbsp;|&nbsp; blue = L &nbsp;|&nbsp; red = R</div>

<div class="wstep">
<span class="wstep-n">Sort</span>
<div><div class="arow"><span class="abk">[</span><span class="ac">-4<span class="pl">&nbsp;</span></span><span class="ac">-1<span class="pl">&nbsp;</span></span><span class="ac">-1<span class="pl">&nbsp;</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div>
<span class="wstep-act">Always sort first &mdash; enables two-pointer + deduplication</span>
</div>

<div class="wstep">
<span class="wstep-n">i=0</span>
<div><div class="arow"><span class="abk">[</span><span class="ac ai">-4<span class="pl pi">i</span></span><span class="ac aL">-1<span class="pl pL">L</span></span><span class="ac">-1<span class="pl">&nbsp;</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac aR">2<span class="pl pR">R</span></span><span class="abk">]</span></div></div>
<span class="wstep-act">need L+R = -nums[i] = 4
sum = -1+2 = 1 &lt; 4 &rarr; L++</span>
</div>

<div class="wstep">
<span class="wstep-n">i=0</span>
<div><div class="arow"><span class="abk">[</span><span class="ac ai">-4<span class="pl pi">i</span></span><span class="ac">-1<span class="pl">&nbsp;</span></span><span class="ac aL">-1<span class="pl pL">L</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac aR">2<span class="pl pR">R</span></span><span class="abk">]</span></div></div>
<span class="wstep-act">sum = -1+2 = 1 &lt; 4 &rarr; L++</span>
</div>

<div class="wstep">
<span class="wstep-n">i=0</span>
<div><div class="arow"><span class="abk">[</span><span class="ac ai">-4<span class="pl pi">i</span></span><span class="ac">-1<span class="pl">&nbsp;</span></span><span class="ac">-1<span class="pl">&nbsp;</span></span><span class="ac aL">0<span class="pl pL">L</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac aR">2<span class="pl pR">R</span></span><span class="abk">]</span></div></div>
<span class="wstep-act">sum = 0+2 = 2 &lt; 4 &rarr; L++</span>
</div>

<div class="wstep">
<span class="wstep-n">i=0</span>
<div><div class="arow"><span class="abk">[</span><span class="ac ai">-4<span class="pl pi">i</span></span><span class="ac">-1<span class="pl">&nbsp;</span></span><span class="ac">-1<span class="pl">&nbsp;</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac aL">1<span class="pl pL">L</span></span><span class="ac aR">2<span class="pl pR">R</span></span><span class="abk">]</span></div></div>
<span class="wstep-act">sum = 1+2 = 3 &lt; 4, but L &ge; R
&rarr; inner loop ends, move i to 1</span>
</div>

<div class="wstep">
<span class="wstep-n">i=1</span>
<div><div class="arow"><span class="abk">[</span><span class="ac">-4<span class="pl">&nbsp;</span></span><span class="ac ai">-1<span class="pl pi">i</span></span><span class="ac aL">-1<span class="pl pL">L</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac aR">2<span class="pl pR">R</span></span><span class="abk">]</span></div></div>
<span class="wstep-act">need L+R = -nums[i] = 1
sum = -1+2 = 1 = 1 &rarr; FOUND! [-1,-1,2]
skip dupes, L++ R--</span>
</div>

<div class="wstep">
<span class="wstep-n">i=1</span>
<div><div class="arow"><span class="abk">[</span><span class="ac">-4<span class="pl">&nbsp;</span></span><span class="ac ai">-1<span class="pl pi">i</span></span><span class="ac">-1<span class="pl">&nbsp;</span></span><span class="ac aL">0<span class="pl pL">L</span></span><span class="ac aR">1<span class="pl pR">R</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div>
<span class="wstep-act">sum = 0+1 = 1 = 1 &rarr; FOUND! [-1,0,1]
skip dupes, L++ R-- &rarr; L&ge;R, inner loop ends</span>
</div>

<div class="wstep">
<span class="wstep-n">i=2</span>
<div><div class="arow"><span class="abk">[</span><span class="ac">-4<span class="pl">&nbsp;</span></span><span class="ac">-1<span class="pl">&nbsp;</span></span><span class="ac ai">-1<span class="pl pi">i</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div>
<span class="wstep-act">nums[2] == nums[1] == -1 &rarr; duplicate i, skip</span>
</div>

<div class="wstep">
<span class="wstep-n">Done</span>
<div style="color:#6ee7b7;font-family:monospace;font-size:.82rem;padding:8px 0">Result: [[-1, -1, 2], [-1, 0, 1]]</div>
<span class="wstep-act">i=3 onwards: nums[i]=0, 1, 2 &gt; 0 &rarr; break early</span>
</div>

</div>

<strong>Code Template:</strong>
<pre>Arrays.sort(nums);
for (int i = 0; i &lt; n - 2; i++) {
    if (i &gt; 0 &amp;&amp; nums[i] == nums[i-1]) continue;  // skip dup i
    int left = i + 1, right = n - 1;
    while (left &lt; right) {
        int sum = nums[i] + nums[left] + nums[right];
        if      (sum == target) { /* save, skip dupes, L++, R-- */ }
        else if (sum &lt; target)  left++;
        else                    right--;
    }
}</pre>
<div class="prob-tags">
  <span class="prob-tag">P02 3Sum</span>
  <span class="prob-tag">P11 3Sum Closest</span>
  <span class="prob-tag">P12 4Sum</span>
</div>
</div>


<!-- ═══════════════════════════════════════════════════
     TYPE 4 — FILL FROM BACK
════════════════════════════════════════════════════ -->
<div class="type-card t4">
<div class="type-title">&#9315; Fill From Back &nbsp;(Reverse Fill)</div>

<div class="rule-box">
<p><strong>What it is:</strong> You fill a result array <strong>from right to left</strong> (largest value first). Two pointers sit at the two ends of the source data, and you always write the <em>bigger</em> of the two into the next available slot from the right. This avoids overwriting data you still need.</p>
<p><strong>Recognize it when:</strong></p>
<ul>
  <li>You need to merge or transform a sorted array, and writing from the front would overwrite values you still need</li>
  <li>The largest values come from the two ends (e.g., negatives squared become large positives)</li>
  <li>There is pre-allocated tail space (e.g., Merge Sorted Array)</li>
</ul>
<p><strong>The decision rule:</strong></p>
<ul>
  <li>Compare absolute value (or actual value) at <span class="L">L</span> vs <span class="R">R</span></li>
  <li>Write the larger into <code>result[pos--]</code></li>
  <li>Advance the pointer whose value was just written</li>
</ul>
</div>

<strong>Worked Example: Squares of a Sorted Array</strong> &mdash; square <code>[-4,&nbsp;-1,&nbsp;0,&nbsp;3,&nbsp;10]</code> in sorted order

<div class="walk">
<div class="walk-title">Step-by-step trace &nbsp;&mdash;&nbsp; blue = L &nbsp;|&nbsp; red = R &nbsp;|&nbsp; green = written to result</div>

<div class="wstep">
<span class="wstep-n">Start</span>
<div>
  <div style="font-size:.75rem;color:#64748b;font-family:monospace;margin-bottom:3px">source array:</div>
  <div class="arow"><span class="abk">[</span><span class="ac aL">-4<span class="pl pL">L</span></span><span class="ac">-1<span class="pl">&nbsp;</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac aR">10<span class="pl pR">R</span></span><span class="abk">]</span></div>
  <div style="font-size:.75rem;color:#64748b;font-family:monospace;margin-top:6px;margin-bottom:3px">result (pos=4):</div>
  <div class="arow"><span class="abk">[</span><span class="ac">_<span class="pl">&nbsp;</span></span><span class="ac">_<span class="pl">&nbsp;</span></span><span class="ac">_<span class="pl">&nbsp;</span></span><span class="ac">_<span class="pl">&nbsp;</span></span><span class="ac">_<span class="pl">&nbsp;</span></span><span class="abk">]</span></div>
</div>
<span class="wstep-act">|L| = |-4| = 4
|R| = |10| = 10</span>
</div>

<div class="wstep">
<span class="wstep-n">Step 1</span>
<div>
  <div class="arow"><span class="abk">[</span><span class="ac aL">-4<span class="pl pL">L</span></span><span class="ac">-1<span class="pl">&nbsp;</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac aR">10<span class="pl pR">R</span></span><span class="abk">]</span></div>
  <div class="arow" style="margin-top:6px"><span class="abk">[</span><span class="ac">_<span class="pl">&nbsp;</span></span><span class="ac">_<span class="pl">&nbsp;</span></span><span class="ac">_<span class="pl">&nbsp;</span></span><span class="ac">_<span class="pl">&nbsp;</span></span><span class="ac aW">100<span class="pl">&nbsp;</span></span><span class="abk">]</span></div>
</div>
<span class="wstep-act">|R|=10 &gt; |L|=4
&rarr; write 10&sup2;=100 at result[4]
R-- (pos=3)</span>
</div>

<div class="wstep">
<span class="wstep-n">Step 2</span>
<div>
  <div class="arow"><span class="abk">[</span><span class="ac aL">-4<span class="pl pL">L</span></span><span class="ac">-1<span class="pl">&nbsp;</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac aR">3<span class="pl pR">R</span></span><span class="ac">10<span class="pl">&nbsp;</span></span><span class="abk">]</span></div>
  <div class="arow" style="margin-top:6px"><span class="abk">[</span><span class="ac">_<span class="pl">&nbsp;</span></span><span class="ac">_<span class="pl">&nbsp;</span></span><span class="ac">_<span class="pl">&nbsp;</span></span><span class="ac aW">16<span class="pl">&nbsp;</span></span><span class="ac aW">100<span class="pl">&nbsp;</span></span><span class="abk">]</span></div>
</div>
<span class="wstep-act">|L|=4 &gt; |R|=3
&rarr; write (-4)&sup2;=16 at result[3]
L++ (pos=2)</span>
</div>

<div class="wstep">
<span class="wstep-n">Step 3</span>
<div>
  <div class="arow"><span class="abk">[</span><span class="ac">-4<span class="pl">&nbsp;</span></span><span class="ac aL">-1<span class="pl pL">L</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac aR">3<span class="pl pR">R</span></span><span class="ac">10<span class="pl">&nbsp;</span></span><span class="abk">]</span></div>
  <div class="arow" style="margin-top:6px"><span class="abk">[</span><span class="ac">_<span class="pl">&nbsp;</span></span><span class="ac">_<span class="pl">&nbsp;</span></span><span class="ac aW">9<span class="pl">&nbsp;</span></span><span class="ac aW">16<span class="pl">&nbsp;</span></span><span class="ac aW">100<span class="pl">&nbsp;</span></span><span class="abk">]</span></div>
</div>
<span class="wstep-act">|R|=3 &gt; |L|=1
&rarr; write 3&sup2;=9 at result[2]
R-- (pos=1)</span>
</div>

<div class="wstep">
<span class="wstep-n">Step 4</span>
<div>
  <div class="arow"><span class="abk">[</span><span class="ac">-4<span class="pl">&nbsp;</span></span><span class="ac aL">-1<span class="pl pL">L</span></span><span class="ac aR">0<span class="pl pR">R</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac">10<span class="pl">&nbsp;</span></span><span class="abk">]</span></div>
  <div class="arow" style="margin-top:6px"><span class="abk">[</span><span class="ac">_<span class="pl">&nbsp;</span></span><span class="ac aW">1<span class="pl">&nbsp;</span></span><span class="ac aW">9<span class="pl">&nbsp;</span></span><span class="ac aW">16<span class="pl">&nbsp;</span></span><span class="ac aW">100<span class="pl">&nbsp;</span></span><span class="abk">]</span></div>
</div>
<span class="wstep-act">|L|=1 &gt; |R|=0
&rarr; write (-1)&sup2;=1 at result[1]
L++ (pos=0)</span>
</div>

<div class="wstep">
<span class="wstep-n">Step 5</span>
<div>
  <div class="arow"><span class="abk">[</span><span class="ac">-4<span class="pl">&nbsp;</span></span><span class="ac">-1<span class="pl">&nbsp;</span></span><span class="ac aL aR">0<span class="pl" style="color:#a78bfa">L=R</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac">10<span class="pl">&nbsp;</span></span><span class="abk">]</span></div>
  <div class="arow" style="margin-top:6px"><span class="abk">[</span><span class="ac aW">0<span class="pl">&nbsp;</span></span><span class="ac aW">1<span class="pl">&nbsp;</span></span><span class="ac aW">9<span class="pl">&nbsp;</span></span><span class="ac aW">16<span class="pl">&nbsp;</span></span><span class="ac aW">100<span class="pl">&nbsp;</span></span><span class="abk">]</span></div>
</div>
<span class="wstep-act">L == R &rarr; write 0&sup2;=0 at result[0]
Loop ends. Done!</span>
</div>

</div>

<strong>Code Template:</strong>
<pre>int left = 0, right = n - 1, pos = n - 1;
int[] result = new int[n];
while (left &lt;= right) {
    int lVal = Math.abs(nums[left]);
    int rVal = Math.abs(nums[right]);
    if (lVal &gt; rVal) { result[pos--] = lVal * lVal; left++;  }
    else             { result[pos--] = rVal * rVal; right--; }
}</pre>
<div class="prob-tags">
  <span class="prob-tag">P08 Squares of Sorted Array</span>
  <span class="prob-tag">P14 Merge Sorted Array</span>
  <span class="prob-tag">P15 Backspace String Compare</span>
</div>
</div>


<!-- ═══════════════════════════════════════════════════
     TYPE 5 — THREE POINTER (PARTITION)
════════════════════════════════════════════════════ -->
<div class="type-card t5">
<div class="type-title">&#9316; Three Pointer &nbsp;(Partition)</div>

<div class="rule-box">
<p><strong>What it is:</strong> Three boundaries divide the array into four zones: <em>processed-left</em>, <em>unknown-middle</em>, <em>processed-right</em>. The <span class="S">low</span> pointer is the right edge of the "left zone". The <span class="F">mid</span> pointer is the scanner. The <span class="M">high</span> pointer is the left edge of the "right zone". The middle shrinks until <span class="F">mid</span> passes <span class="M">high</span>.</p>
<p><strong>Recognize it when:</strong></p>
<ul>
  <li>Three-category partition in a single pass (classic Dutch National Flag)</li>
  <li>Two pointers are not enough because there are three distinct groups</li>
</ul>
<p><strong>The decision rule (for 0/1/2 sort):</strong></p>
<ul>
  <li><span class="F">nums[mid]</span> == 0 &rarr; swap(<span class="F">mid</span>, <span class="S">low</span>), <span class="S">low++</span>, <span class="F">mid++</span></li>
  <li><span class="F">nums[mid]</span> == 1 &rarr; <span class="F">mid++</span> only (already in place)</li>
  <li><span class="F">nums[mid]</span> == 2 &rarr; swap(<span class="F">mid</span>, <span class="M">high</span>), <span class="M">high--</span> &nbsp;<strong>but do NOT mid++</strong> (swapped value is unknown!)</li>
</ul>
</div>

<strong>Worked Example: Sort Colors</strong> &mdash; sort <code>[2,&nbsp;0,&nbsp;2,&nbsp;1,&nbsp;1,&nbsp;0]</code> in one pass

<div class="walk">
<div class="walk-title">Step-by-step trace &nbsp;&mdash;&nbsp; green = low (S) &nbsp;|&nbsp; orange = mid (F) &nbsp;|&nbsp; indigo = high (H) &nbsp;|&nbsp; cell shows current array state</div>

<div class="wstep">
<span class="wstep-n">Start</span>
<div><div class="arow"><span class="abk">[</span><span class="ac aS aF">2<span class="pl pS">S/F</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac aH">0<span class="pl pH">H</span></span><span class="abk">]</span></div></div>
<span class="wstep-act">low=0, mid=0, high=5
S and F start together at index 0</span>
</div>

<div class="wstep">
<span class="wstep-n">Step 1</span>
<div><div class="arow"><span class="abk">[</span><span class="ac aF">0<span class="pl pF">F</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac aH">1<span class="pl pH">H</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="abk">]</span></div><div style="font-size:.74rem;color:#64748b;font-family:monospace;margin-top:2px">&nbsp;&nbsp;S also at index 0</div></div>
<span class="wstep-act">mid=0, nums[mid]=2 &rarr; swap(mid, high)
array: [0,0,2,1,1,2]  high-- (high=4)
mid stays at 0 (don't advance!)</span>
</div>

<div class="wstep">
<span class="wstep-n">Step 2</span>
<div><div class="arow"><span class="abk">[</span><span class="ac aS aF">0<span class="pl pS">S/F</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac aH">1<span class="pl pH">H</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div>
<span class="wstep-act">mid=0, nums[mid]=0 &rarr; swap(mid, low)
low++ (low=1), mid++ (mid=1)</span>
</div>

<div class="wstep">
<span class="wstep-n">Step 3</span>
<div><div class="arow"><span class="abk">[</span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac aS aF">0<span class="pl pS">S/F</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac aH">1<span class="pl pH">H</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div>
<span class="wstep-act">mid=1, nums[mid]=0 &rarr; swap(mid, low)
low++ (low=2), mid++ (mid=2)</span>
</div>

<div class="wstep">
<span class="wstep-n">Step 4</span>
<div><div class="arow"><span class="abk">[</span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac aS aF">2<span class="pl pS">S/F</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac aH">1<span class="pl pH">H</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div>
<span class="wstep-act">mid=2, nums[mid]=2 &rarr; swap(mid, high)
array: [0,0,1,1,2,2]  high-- (high=3)
mid stays at 2 (don't advance!)</span>
</div>

<div class="wstep">
<span class="wstep-n">Step 5</span>
<div><div class="arow"><span class="abk">[</span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac aS aF">1<span class="pl pS">S/F</span></span><span class="ac aH">1<span class="pl pH">H</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div>
<span class="wstep-act">mid=2, nums[mid]=1 &rarr; mid++ only
(1 is already in the correct middle zone)</span>
</div>

<div class="wstep">
<span class="wstep-n">Step 6</span>
<div><div class="arow"><span class="abk">[</span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac aS">1<span class="pl pS">S</span></span><span class="ac aF aH">1<span class="pl pF">F/H</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div>
<span class="wstep-act">mid=3, nums[mid]=1 &rarr; mid++ only</span>
</div>

<div class="wstep">
<span class="wstep-n">Done</span>
<div><div class="arow"><span class="abk">[</span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div>
<span class="wstep-act">mid=4 &gt; high=3 &rarr; loop ends
Result: [0, 0, 1, 1, 2, 2]</span>
</div>

</div>

<strong>Code Template:</strong>
<pre>int low = 0, mid = 0, high = n - 1;
while (mid &lt;= high) {
    if      (nums[mid] == 0) swap(nums, low++, mid++);  // send to left zone
    else if (nums[mid] == 1) mid++;                     // already in middle
    else                     swap(nums, mid, high--);   // send to right zone
    // NOTE: do NOT mid++ after swapping a 2 — the new nums[mid] is unknown
}</pre>
<div class="prob-tags">
  <span class="prob-tag">P06 Sort Colors (Dutch National Flag)</span>
</div>
</div>

</div>

<div class="section purple">
<h2>&#128296; Universal Two Pointer Template</h2>
<pre>
// Type 1: Opposite ends
int left = 0, right = n - 1;
while (left &lt; right) {
    if (condition_met)   { /* found */ break; }
    else if (too_small)  { left++;  }   // need bigger value
    else                 { right--; }   // need smaller value
}

// Type 2: Slow + Fast (same direction)
int slow = 0;
for (int fast = 0; fast &lt; n; fast++) {
    if (nums[fast] is "good") {
        nums[slow] = nums[fast];
        slow++;
    }
}
// slow = count of "good" elements
</pre>
</div>

<div class="section red">
<h2>&#128337; Time Complexity</h2>
""" + kv([
    ("Brute Force (no pointer)", "O(n²)"),
    ("Two Pointer", "O(n) after sort"),
    ("Space (usually)", "O(1) extra"),
    ("With Sorting", "O(n log n) total"),
]) + """
<p style="margin-top:12px">Even when you sort first (O(n log n)), this beats the O(n&sup2;) brute force for large inputs.</p>
</div>

<div class="section blue">
<h2>&#128203; Problem Index</h2>
<table style="width:100%;border-collapse:collapse;font-size:.88rem">
<tr style="background:#f1f5f9"><th style="text-align:left;padding:8px">ID</th><th style="text-align:left;padding:8px">Problem</th><th style="padding:8px">LC#</th><th style="padding:8px">Difficulty</th><th style="text-align:left;padding:8px">Type</th></tr>
<tr><td style="padding:7px">P01</td><td style="padding:7px">Two Sum II</td><td style="padding:7px;text-align:center">167</td><td style="padding:7px;text-align:center"><span class="badge easy">Easy</span></td><td style="padding:7px">Opposite Ends</td></tr>
<tr style="background:#f8fafc"><td style="padding:7px">P02</td><td style="padding:7px">3Sum</td><td style="padding:7px;text-align:center">15</td><td style="padding:7px;text-align:center"><span class="badge medium">Med</span></td><td style="padding:7px">Fix + Two Pointer</td></tr>
<tr><td style="padding:7px">P03</td><td style="padding:7px">Container With Most Water</td><td style="padding:7px;text-align:center">11</td><td style="padding:7px;text-align:center"><span class="badge medium">Med</span></td><td style="padding:7px">Opposite Ends</td></tr>
<tr style="background:#f8fafc"><td style="padding:7px">P04</td><td style="padding:7px">Trapping Rain Water</td><td style="padding:7px;text-align:center">42</td><td style="padding:7px;text-align:center"><span class="badge hard">Hard</span></td><td style="padding:7px">Opposite Ends</td></tr>
<tr><td style="padding:7px">P05</td><td style="padding:7px">Remove Duplicates</td><td style="padding:7px;text-align:center">26</td><td style="padding:7px;text-align:center"><span class="badge easy">Easy</span></td><td style="padding:7px">Slow + Fast</td></tr>
<tr style="background:#f8fafc"><td style="padding:7px">P06</td><td style="padding:7px">Sort Colors</td><td style="padding:7px;text-align:center">75</td><td style="padding:7px;text-align:center"><span class="badge medium">Med</span></td><td style="padding:7px">Three Pointer</td></tr>
<tr><td style="padding:7px">P07</td><td style="padding:7px">Move Zeroes</td><td style="padding:7px;text-align:center">283</td><td style="padding:7px;text-align:center"><span class="badge easy">Easy</span></td><td style="padding:7px">Slow + Fast</td></tr>
<tr style="background:#f8fafc"><td style="padding:7px">P08</td><td style="padding:7px">Squares of a Sorted Array</td><td style="padding:7px;text-align:center">977</td><td style="padding:7px;text-align:center"><span class="badge easy">Easy</span></td><td style="padding:7px">Fill From Back</td></tr>
<tr><td style="padding:7px">P09</td><td style="padding:7px">Valid Palindrome</td><td style="padding:7px;text-align:center">125</td><td style="padding:7px;text-align:center"><span class="badge easy">Easy</span></td><td style="padding:7px">Opposite Ends</td></tr>
<tr style="background:#f8fafc"><td style="padding:7px">P10</td><td style="padding:7px">Reverse String</td><td style="padding:7px;text-align:center">344</td><td style="padding:7px;text-align:center"><span class="badge easy">Easy</span></td><td style="padding:7px">Opposite Ends</td></tr>
<tr><td style="padding:7px">P11</td><td style="padding:7px">3Sum Closest</td><td style="padding:7px;text-align:center">16</td><td style="padding:7px;text-align:center"><span class="badge medium">Med</span></td><td style="padding:7px">Fix + Two Pointer</td></tr>
<tr style="background:#f8fafc"><td style="padding:7px">P12</td><td style="padding:7px">4Sum</td><td style="padding:7px;text-align:center">18</td><td style="padding:7px;text-align:center"><span class="badge medium">Med</span></td><td style="padding:7px">Fix + Two Pointer</td></tr>
<tr><td style="padding:7px">P13</td><td style="padding:7px">Boats to Save People</td><td style="padding:7px;text-align:center">881</td><td style="padding:7px;text-align:center"><span class="badge medium">Med</span></td><td style="padding:7px">Opposite Ends</td></tr>
<tr style="background:#f8fafc"><td style="padding:7px">P14</td><td style="padding:7px">Merge Sorted Array</td><td style="padding:7px;text-align:center">88</td><td style="padding:7px;text-align:center"><span class="badge easy">Easy</span></td><td style="padding:7px">Fill From Back</td></tr>
<tr><td style="padding:7px">P15</td><td style="padding:7px">Backspace String Compare</td><td style="padding:7px;text-align:center">844</td><td style="padding:7px;text-align:center"><span class="badge easy">Easy</span></td><td style="padding:7px">Opposite Ends (RTL)</td></tr>
<tr style="background:#f8fafc"><td style="padding:7px">P16</td><td style="padding:7px">Is Subsequence</td><td style="padding:7px;text-align:center">392</td><td style="padding:7px;text-align:center"><span class="badge easy">Easy</span></td><td style="padding:7px">Same Direction</td></tr>
<tr><td style="padding:7px">P17</td><td style="padding:7px">Remove Element</td><td style="padding:7px;text-align:center">27</td><td style="padding:7px;text-align:center"><span class="badge easy">Easy</span></td><td style="padding:7px">Slow + Fast</td></tr>
<tr style="background:#f8fafc"><td style="padding:7px">P18</td><td style="padding:7px">Find K Closest Elements</td><td style="padding:7px;text-align:center">658</td><td style="padding:7px;text-align:center"><span class="badge medium">Med</span></td><td style="padding:7px">Opposite Ends (shrink)</td></tr>
<tr><td style="padding:7px">P19</td><td style="padding:7px">Shortest Unsorted Subarray</td><td style="padding:7px;text-align:center">581</td><td style="padding:7px;text-align:center"><span class="badge medium">Med</span></td><td style="padding:7px">Opposite Ends</td></tr>
<tr style="background:#f8fafc"><td style="padding:7px">P20</td><td style="padding:7px">Minimize Maximum Pair Sum</td><td style="padding:7px;text-align:center">1877</td><td style="padding:7px;text-align:center"><span class="badge medium">Med</span></td><td style="padding:7px">Opposite Ends</td></tr>
</table>
</div>
"""
    return make_page("Two Pointer Masterclass", body)


# ──────────────────────────────────────────────────────────────
#  PROBLEM DATA  (all 20 problems)
# ──────────────────────────────────────────────────────────────
PROBLEMS = [

# ── P01 ──────────────────────────────────────────────────────
dict(
num="P01", filename="P01_TwoSumII",
title="Two Sum II – Input Array Is Sorted",
lc=167, diff="Easy", dtype="Opposite Ends",
problem="""
<p>Given a <strong>1-indexed sorted array</strong> of integers and a <code>target</code>, return the 1-based indices <code>[i, j]</code> (i &lt; j) of the two numbers that sum to <code>target</code>. Exactly one solution exists. Use <strong>O(1) extra space</strong>.</p>
<p><strong>Example:</strong> <code>numbers = [2, 7, 11, 15], target = 9</code> &rarr; <code>[1, 2]</code> (2 + 7 = 9)</p>
""",
layman="""
<p>Think of the array as a number line. You put your <strong>left finger</strong> on the smallest number and your <strong>right finger</strong> on the largest. You check their sum:</p>
<ul style="padding-left:22px;margin:8px 0">
  <li><strong>Sum too big?</strong> Move right finger left (need a smaller right number).</li>
  <li><strong>Sum too small?</strong> Move left finger right (need a bigger left number).</li>
  <li><strong>Sum == target?</strong> Done!</li>
</ul>
<p>Because the array is sorted, every move eliminates an entire column of brute-force pairs.</p>
""",
aha="The array is sorted — moving a pointer in one direction predictably changes the sum. Moving both pointers toward each other guarantees we won't miss the answer.",
visual="""Input:  [2,  7, 11, 15],  target = 9

Step 1:  L=0, R=3   sum = 2+15 = 17  &gt; 9  → move R left
         [2,  7, 11, 15]
          L           R

Step 2:  L=0, R=2   sum = 2+11 = 13  &gt; 9  → move R left
         [2,  7, 11, 15]
          L       R

Step 3:  L=0, R=1   sum = 2+7  = 9   = 9  → FOUND!  return [1,2]
         [2,  7, 11, 15]
          L   R""",
algo=[
    "Set <code>left = 0</code>, <code>right = n-1</code>.",
    "While <code>left &lt; right</code>: compute <code>sum = nums[left] + nums[right]</code>.",
    "If <code>sum == target</code>: return <code>[left+1, right+1]</code> (1-indexed).",
    "If <code>sum &lt; target</code>: <code>left++</code> (need bigger value).",
    "If <code>sum &gt; target</code>: <code>right--</code> (need smaller value).",
],
java="""public int[] twoSum(int[] numbers, int target) {
    int left = 0, right = numbers.length - 1;
    while (left < right) {
        int sum = numbers[left] + numbers[right];
        if      (sum == target) return new int[]{left + 1, right + 1};
        else if (sum < target)  left++;
        else                    right--;
    }
    return new int[]{};   // guaranteed one solution, never reached
}""",
time="O(n)", space="O(1)",
pattern="Classic converging two-pointer on a sorted array. The sorted order is the prerequisite that makes each pointer move decisive — you never need to backtrack.",
key="Sorted + find pair → opposite-end pointers. Move the pointer whose side makes the sum go in the right direction.",
walk_html="""<div class="walk">
<div class="walk-title">Trace — blue=L &nbsp;|&nbsp; red=R &nbsp;|&nbsp; array=[2,7,11,15], target=9</div>
<div class="wstep"><span class="wstep-n">Start</span><div><div class="arow"><span class="abk">[</span><span class="ac aL">2<span class="pl pL">L</span></span><span class="ac">7<span class="pl">&nbsp;</span></span><span class="ac">11<span class="pl">&nbsp;</span></span><span class="ac aR">15<span class="pl pR">R</span></span><span class="abk">]</span></div></div><span class="wstep-act">L=0 (val 2), R=3 (val 15) — place pointers at both ends</span></div>
<div class="wstep"><span class="wstep-n">Step 1</span><div><div class="arow"><span class="abk">[</span><span class="ac aL">2<span class="pl pL">L</span></span><span class="ac">7<span class="pl">&nbsp;</span></span><span class="ac">11<span class="pl">&nbsp;</span></span><span class="ac aR">15<span class="pl pR">R</span></span><span class="abk">]</span></div></div><span class="wstep-act">sum = 2+15 = 17 &gt; 9 &rarr; too big &rarr; R-- (move R left)</span></div>
<div class="wstep"><span class="wstep-n">Step 2</span><div><div class="arow"><span class="abk">[</span><span class="ac aL">2<span class="pl pL">L</span></span><span class="ac">7<span class="pl">&nbsp;</span></span><span class="ac aR">11<span class="pl pR">R</span></span><span class="ac">15<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">sum = 2+11 = 13 &gt; 9 &rarr; too big &rarr; R--</span></div>
<div class="wstep"><span class="wstep-n">Step 3</span><div><div class="arow"><span class="abk">[</span><span class="ac aL">2<span class="pl pL">L</span></span><span class="ac aR">7<span class="pl pR">R</span></span><span class="ac">11<span class="pl">&nbsp;</span></span><span class="ac">15<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">sum = 2+7 = 9 = target &rarr; FOUND! return [L+1, R+1] = [1, 2] (1-indexed)</span></div>
</div>"""
),

# ── P02 ──────────────────────────────────────────────────────
dict(
num="P02", filename="P02_ThreeSum",
title="3Sum",
lc=15, diff="Medium", dtype="Fix One + Two Pointer",
problem="""
<p>Given an integer array <code>nums</code>, return all unique triplets <code>[a, b, c]</code> such that <code>a + b + c = 0</code>. The solution set must not contain duplicates.</p>
<p><strong>Example:</strong> <code>[-1,0,1,2,-1,-4]</code> &rarr; <code>[[-1,-1,2],[-1,0,1]]</code></p>
""",
layman="""
<p>This is just P01 run many times. Sort the array. <strong>Fix one number</strong> (<code>i</code>) and run Two Sum II on everything to the right, looking for a sum of <code>-nums[i]</code>.</p>
<p>Duplicates? After sorting, same values are adjacent. Skip <code>i</code> when it matches the previous. After finding a triplet, skip the inner pointers past duplicates too.</p>
""",
aha="3Sum = Sort + (for each element: Two Sum II on the rest). Sorting is what lets you deduplicate efficiently.",
visual="""Sorted: [-4, -1, -1, 0, 1, 2]

Fix i=1 (nums[i]=-1), need L+R = 1:
         [-4, -1, -1,  0,  1,  2]
               i   L           R    sum=-1+2=1 ✓  → save [-1,-1,2], skip dupes, L++,R--

Fix i=1 (nums[i]=-1), need L+R = 1:
         [-4, -1, -1,  0,  1,  2]
               i        L   R       sum=0+1=1 ✓  → save [-1,0,1], skip dupes, L++,R--

L&gt;=R → inner loop ends, i moves to i=2 (but nums[2]==nums[1]) → skip""",
algo=[
    "Sort <code>nums</code>.",
    "Loop <code>i</code> from 0 to <code>n-3</code>. If <code>nums[i] &gt; 0</code>, break (sum can never be 0). If <code>i &gt; 0 &amp;&amp; nums[i]==nums[i-1]</code>, skip.",
    "Set <code>left = i+1</code>, <code>right = n-1</code>.",
    "Run Two Sum II targeting <code>-nums[i]</code>.",
    "On match: save triplet. Skip duplicate <code>left</code> and <code>right</code> values before advancing.",
],
java="""public List&lt;List&lt;Integer&gt;&gt; threeSum(int[] nums) {
    List&lt;List&lt;Integer&gt;&gt; res = new ArrayList&lt;&gt;();
    Arrays.sort(nums);
    for (int i = 0; i &lt; nums.length - 2; i++) {
        if (nums[i] &gt; 0) break;                         // rest can only be positive
        if (i &gt; 0 &amp;&amp; nums[i] == nums[i-1]) continue;    // skip duplicate i
        int left = i + 1, right = nums.length - 1;
        while (left &lt; right) {
            int sum = nums[i] + nums[left] + nums[right];
            if (sum == 0) {
                res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                while (left &lt; right &amp;&amp; nums[left]  == nums[left+1])  left++;
                while (left &lt; right &amp;&amp; nums[right] == nums[right-1]) right--;
                left++; right--;
            } else if (sum &lt; 0) left++;
            else                right--;
        }
    }
    return res;
}""",
time="O(n²)", space="O(1) extra (output excluded)",
pattern="Fix + Two Pointer: lock one element, two-pointer the subarray to the right. Skip duplicates at every level.",
key="3Sum = Sort + iterate i + Two Sum II inside. Always skip duplicates after sort to avoid repeated triplets.",
walk_html="""<div class="walk">
<div class="walk-title">Trace — purple=i (fixed) &nbsp;|&nbsp; blue=L &nbsp;|&nbsp; red=R &nbsp;|&nbsp; sorted: [-4,-1,-1,0,1,2], target=0</div>
<div class="wstep"><span class="wstep-n">Sort</span><div><div class="arow"><span class="abk">[</span><span class="ac">-4<span class="pl">&nbsp;</span></span><span class="ac">-1<span class="pl">&nbsp;</span></span><span class="ac">-1<span class="pl">&nbsp;</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">Sort first — enables two-pointer and efficient deduplication</span></div>
<div class="wstep"><span class="wstep-n">i=0</span><div><div class="arow"><span class="abk">[</span><span class="ac ai">-4<span class="pl pi">i</span></span><span class="ac aL">-1<span class="pl pL">L</span></span><span class="ac">-1<span class="pl">&nbsp;</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac aR">2<span class="pl pR">R</span></span><span class="abk">]</span></div></div><span class="wstep-act">need L+R=4. All combos: max is -1+2=1 &lt; 4. No solution for i=0 &rarr; move i</span></div>
<div class="wstep"><span class="wstep-n">i=1</span><div><div class="arow"><span class="abk">[</span><span class="ac">-4<span class="pl">&nbsp;</span></span><span class="ac ai">-1<span class="pl pi">i</span></span><span class="ac aL">-1<span class="pl pL">L</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac aR">2<span class="pl pR">R</span></span><span class="abk">]</span></div></div><span class="wstep-act">need L+R=1. sum=-1+2=1 &rarr; FOUND! save [-1,-1,2]. Skip dupes, L++, R--</span></div>
<div class="wstep"><span class="wstep-n">i=1</span><div><div class="arow"><span class="abk">[</span><span class="ac">-4<span class="pl">&nbsp;</span></span><span class="ac ai">-1<span class="pl pi">i</span></span><span class="ac">-1<span class="pl">&nbsp;</span></span><span class="ac aL">0<span class="pl pL">L</span></span><span class="ac aR">1<span class="pl pR">R</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">sum=0+1=1 &rarr; FOUND! save [-1,0,1]. L++ R-- &rarr; L&ge;R, inner done</span></div>
<div class="wstep"><span class="wstep-n">i=2</span><div><div class="arow"><span class="abk">[</span><span class="ac">-4<span class="pl">&nbsp;</span></span><span class="ac">-1<span class="pl">&nbsp;</span></span><span class="ac ai">-1<span class="pl pi">i</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">nums[2]==-1 == nums[1]==-1 &rarr; duplicate i, skip. i=3: 0 not &gt; 0, but inner loop finds nothing new. Done.</span></div>
<div class="wstep"><span class="wstep-n">Result</span><div style="color:#6ee7b7;font-family:monospace;font-size:.82rem;padding:8px 0">[[-1,-1,2], [-1,0,1]]</div><span class="wstep-act">2 unique triplets found in O(n&sup2;) time</span></div>
</div>"""
),

# ── P03 ──────────────────────────────────────────────────────
dict(
num="P03", filename="P03_ContainerWithMostWater",
title="Container With Most Water",
lc=11, diff="Medium", dtype="Opposite Ends",
problem="""
<p>Given <code>n</code> vertical bars where <code>height[i]</code> is the bar's height, find two bars that together form a container holding the most water. The container's width is the distance between bars; its height is the shorter of the two bars.</p>
<p><strong>Example:</strong> <code>[1,8,6,2,5,4,8,3,7]</code> &rarr; <code>49</code></p>
""",
layman="""
<p>Picture two walls of a fish tank. The amount of water is <code>width × shorter wall</code>. Start with the widest possible tank (pointers at both ends). Moving the <em>taller</em> wall inward can only shrink width — it gains nothing because the shorter wall still limits height. So <strong>always move the shorter wall</strong> inward; that's the only move that can possibly find a taller limiting wall and increase area.</p>
""",
aha="You start with maximum width. Moving the taller wall never helps (area is limited by the shorter). Always move the shorter wall — only that can improve the result.",
visual="""[1, 8, 6, 2, 5, 4, 8, 3, 7]
 L                          R    w=8, h=min(1,7)=1, area=8
 L                      R        w=7, h=min(1,3)=1, area=7   (moved L because h[L]&lt;h[R])
 L                  R            w=6, h=min(1,8)=1, area=6
    L               R            w=5, h=min(8,8)=8, area=40  ← new max!  (moved L, h[L]&lt;h[R])
    ...eventually...
    L           R                w=5, h=min(8,7)=7, area=49  ← MAXIMUM""",
algo=[
    "Set <code>left=0</code>, <code>right=n-1</code>, <code>maxWater=0</code>.",
    "While <code>left &lt; right</code>: compute <code>area = (right-left) * min(height[left], height[right])</code>.",
    "Update <code>maxWater</code>.",
    "Move the pointer with the <strong>shorter</strong> bar inward (that's the bottleneck).",
],
java="""public int maxArea(int[] height) {
    int left = 0, right = height.length - 1, maxWater = 0;
    while (left &lt; right) {
        int h    = Math.min(height[left], height[right]);
        int area = h * (right - left);
        maxWater = Math.max(maxWater, area);
        if (height[left] &lt; height[right]) left++;
        else                               right--;
    }
    return maxWater;
}""",
time="O(n)", space="O(1)",
pattern="Greedy opposite-end two-pointer: you can prove that moving the taller pointer never improves the result, so you never need to try it.",
key="Area = width × min(heights). Move the shorter wall — it's the only move with potential upside.",
walk_html="""<div class="walk">
<div class="walk-title">Trace — blue=L &nbsp;|&nbsp; red=R &nbsp;|&nbsp; area=(R-L)&times;min(h[L],h[R]) &nbsp;|&nbsp; always move shorter side</div>
<div class="wstep"><span class="wstep-n">Start</span><div><div class="arow"><span class="abk">[</span><span class="ac aL">1<span class="pl pL">L</span></span><span class="ac">8<span class="pl">&nbsp;</span></span><span class="ac">6<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">5<span class="pl">&nbsp;</span></span><span class="ac">4<span class="pl">&nbsp;</span></span><span class="ac">8<span class="pl">&nbsp;</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac aR">7<span class="pl pR">R</span></span><span class="abk">]</span></div></div><span class="wstep-act">w=8, h=min(1,7)=1, area=8. h[L]&lt;h[R] &rarr; move L (shorter side)</span></div>
<div class="wstep"><span class="wstep-n">Step 1</span><div><div class="arow"><span class="abk">[</span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac aL">8<span class="pl pL">L</span></span><span class="ac">6<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">5<span class="pl">&nbsp;</span></span><span class="ac">4<span class="pl">&nbsp;</span></span><span class="ac">8<span class="pl">&nbsp;</span></span><span class="ac aR">7<span class="pl pR">R</span></span><span class="ac">7<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">w=7, h=min(8,7)=7, area=49 &larr; new max! h[R]&lt;h[L] &rarr; R--</span></div>
<div class="wstep"><span class="wstep-n">Step 2</span><div><div class="arow"><span class="abk">[</span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac aL">8<span class="pl pL">L</span></span><span class="ac">6<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">5<span class="pl">&nbsp;</span></span><span class="ac">4<span class="pl">&nbsp;</span></span><span class="ac aR">8<span class="pl pR">R</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac">7<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">w=5, h=min(8,8)=8, area=40. Tie &rarr; R--</span></div>
<div class="wstep"><span class="wstep-n">Step 3</span><div><div class="arow"><span class="abk">[</span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac aL">8<span class="pl pL">L</span></span><span class="ac">6<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">5<span class="pl">&nbsp;</span></span><span class="ac aR">4<span class="pl pR">R</span></span><span class="ac">8<span class="pl">&nbsp;</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac">7<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">w=4, h=min(8,4)=4, area=16. h[R]&lt;h[L] &rarr; R--. Continuing... L and R converge.</span></div>
<div class="wstep"><span class="wstep-n">Done</span><div style="color:#6ee7b7;font-family:monospace;font-size:.82rem;padding:8px 0">maxWater = 49</div><span class="wstep-act">Pointers crossed — return 49. Moving taller wall never beats moving shorter: proven greedy.</span></div>
</div>"""
),

# ── P04 ──────────────────────────────────────────────────────
dict(
num="P04", filename="P04_TrappingRainWater",
title="Trapping Rain Water",
lc=42, diff="Hard", dtype="Opposite Ends",
problem="""
<p>Given an elevation map as an array of heights, compute how much water it can trap after rain. Water at position <code>i</code> is limited by the shortest wall on either side.</p>
<p><strong>Example:</strong> <code>[0,1,0,2,1,0,1,3,2,1,2,1]</code> &rarr; <code>6</code></p>
""",
layman="""
<p>Each column can hold water up to <code>min(tallest wall on its left, tallest wall on its right) - its own height</code>. The trick: you don't need to scan both sides separately for every column. Use two pointers from the ends. Whichever side has the <strong>smaller max-so-far</strong> is the definite bottleneck. Process that side — its water amount is already decided. Move that pointer inward.</p>
""",
aha="Water at a position depends on the min of the two sides' maximums. Two pointers let you process whichever side's maximum is smaller — that side's water is already fully determined.",
visual="""[0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
 L                                      R

leftMax=0, rightMax=1 → process LEFT (leftMax &lt; rightMax)
  height[L]=0 &gt;= leftMax → update leftMax=0, no water. L++

leftMax=0, rightMax=1 → process LEFT
  height[L]=1 &gt;= leftMax → update leftMax=1, no water. L++

leftMax=1, rightMax=1 → process LEFT (tie, either works)
  height[L]=0 &lt; leftMax=1 → water += 1-0 = 1. L++
...and so on until L meets R.""",
algo=[
    "Set <code>left=0</code>, <code>right=n-1</code>, <code>leftMax=0</code>, <code>rightMax=0</code>, <code>water=0</code>.",
    "While <code>left &lt; right</code>: if <code>height[left] &lt; height[right]</code>, process left side; else right side.",
    "Process left: if <code>height[left] &gt;= leftMax</code>, update <code>leftMax</code>; else <code>water += leftMax - height[left]</code>. Then <code>left++</code>.",
    "Process right: same logic mirrored. Then <code>right--</code>.",
],
java="""public int trap(int[] height) {
    int left = 0, right = height.length - 1;
    int leftMax = 0, rightMax = 0, water = 0;
    while (left &lt; right) {
        if (height[left] &lt; height[right]) {
            if (height[left] &gt;= leftMax) leftMax = height[left];
            else                          water += leftMax - height[left];
            left++;
        } else {
            if (height[right] &gt;= rightMax) rightMax = height[right];
            else                            water += rightMax - height[right];
            right--;
        }
    }
    return water;
}""",
time="O(n)", space="O(1)",
pattern="Same opposite-end two-pointer as Container. But instead of finding a pair, you're accumulating a result by processing one cell at a time, guided by which side's max is smaller.",
key="Process the side with the smaller running max — that side's water is already 100% determined.",
walk_html="""<div class="walk">
<div class="walk-title">Trace — blue=L &nbsp;|&nbsp; red=R &nbsp;|&nbsp; array=[3,0,2,0,4] (simplified) — process side with smaller max</div>
<div class="wstep"><span class="wstep-n">Start</span><div><div class="arow"><span class="abk">[</span><span class="ac aL">3<span class="pl pL">L</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac aR">4<span class="pl pR">R</span></span><span class="abk">]</span></div></div><span class="wstep-act">leftMax=3, rightMax=4. leftMax&lt;rightMax &rarr; process L side</span></div>
<div class="wstep"><span class="wstep-n">Step 1</span><div><div class="arow"><span class="abk">[</span><span class="ac aL">3<span class="pl pL">L</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac aR">4<span class="pl pR">R</span></span><span class="abk">]</span></div></div><span class="wstep-act">h[L]=3 &ge; leftMax=3 &rarr; update leftMax=3, no water here. L++</span></div>
<div class="wstep"><span class="wstep-n">Step 2</span><div><div class="arow"><span class="abk">[</span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac aL">0<span class="pl pL">L</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac aR">4<span class="pl pR">R</span></span><span class="abk">]</span></div></div><span class="wstep-act">leftMax=3 &lt; rightMax=4 &rarr; process L. h[L]=0 &lt; leftMax=3 &rarr; water+=3-0=3. L++</span></div>
<div class="wstep"><span class="wstep-n">Step 3</span><div><div class="arow"><span class="abk">[</span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac aL">2<span class="pl pL">L</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac aR">4<span class="pl pR">R</span></span><span class="abk">]</span></div></div><span class="wstep-act">leftMax=3 &lt; rightMax=4 &rarr; process L. h[L]=2 &lt; leftMax=3 &rarr; water+=3-2=1. L++</span></div>
<div class="wstep"><span class="wstep-n">Step 4</span><div><div class="arow"><span class="abk">[</span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac aL">0<span class="pl pL">L</span></span><span class="ac aR">4<span class="pl pR">R</span></span><span class="abk">]</span></div></div><span class="wstep-act">leftMax=3 &lt; rightMax=4 &rarr; process L. h[L]=0 &lt; leftMax=3 &rarr; water+=3-0=3. L++</span></div>
<div class="wstep"><span class="wstep-n">Done</span><div style="color:#6ee7b7;font-family:monospace;font-size:.82rem;padding:8px 0">Total water = 3+1+3 = 7 units</div><span class="wstep-act">L&ge;R &rarr; loop ends. Key insight: leftMax guaranteed the water — rightMax was always larger.</span></div>
</div>"""
),

# ── P05 ──────────────────────────────────────────────────────
dict(
num="P05", filename="P05_RemoveDuplicates",
title="Remove Duplicates from Sorted Array",
lc=26, diff="Easy", dtype="Slow + Fast",
problem="""
<p>Given a <strong>sorted</strong> array, remove duplicates <strong>in-place</strong> so each value appears only once. Return the number of unique elements. Elements beyond that count are ignored.</p>
<p><strong>Example:</strong> <code>[0,0,1,1,1,2,2,3,3,4]</code> &rarr; return <code>5</code>, array becomes <code>[0,1,2,3,4,_,_,_,_,_]</code></p>
""",
layman="""
<p>Imagine a tape recorder with a <strong>play head</strong> (fast) that reads every value, and a <strong>record head</strong> (slow) that only writes when it finds something new. The record head stays put on duplicates; it only advances when the play head finds a new unique number. At the end, the record position tells you how many unique elements exist.</p>
""",
aha="Slow pointer is the 'write cursor' — it only advances when fast finds a value different from what slow is sitting on.",
visual="""[0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
 S  F                                   nums[F]==nums[S] → just move F

[0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
 S     F                                nums[F]!=nums[S] → S++, write nums[F] there, move F

[0, 1, 1, 1, 1, 2, 2, 3, 3, 4]
    S     F                             nums[F]==nums[S] → just move F
...
Final: [0,1,2,3,4, ...] , slow+1 = 5""",
algo=[
    "If array is empty, return 0.",
    "Set <code>slow = 0</code>.",
    "Loop <code>fast</code> from 1 to <code>n-1</code>.",
    "If <code>nums[fast] != nums[slow]</code>: <code>slow++</code>, then <code>nums[slow] = nums[fast]</code>.",
    "Return <code>slow + 1</code>.",
],
java="""public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    int slow = 0;
    for (int fast = 1; fast &lt; nums.length; fast++) {
        if (nums[fast] != nums[slow]) {
            slow++;
            nums[slow] = nums[fast];
        }
    }
    return slow + 1;
}""",
time="O(n)", space="O(1)",
pattern="Slow+Fast (same direction): slow = write cursor, fast = read cursor. Write only when fast finds something new.",
key="slow marks the last written unique position. Only advance slow when fast finds a new value.",
walk_html="""<div class="walk">
<div class="walk-title">Trace — green=S (write head) &nbsp;|&nbsp; orange=F (reader) &nbsp;|&nbsp; array=[0,0,1,1,2,3,3,4]</div>
<div class="wstep"><span class="wstep-n">Start</span><div><div class="arow"><span class="abk">[</span><span class="ac aS aF">0<span class="pl pS">S/F</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac">4<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">S=0, F=1 (F starts at 1)</span></div>
<div class="wstep"><span class="wstep-n">Step 1</span><div><div class="arow"><span class="abk">[</span><span class="ac aS">0<span class="pl pS">S</span></span><span class="ac aF">0<span class="pl pF">F</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac">4<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">nums[F]=0 == nums[S]=0 &rarr; duplicate, skip. F++</span></div>
<div class="wstep"><span class="wstep-n">Step 2</span><div><div class="arow"><span class="abk">[</span><span class="ac aS">0<span class="pl pS">S</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac aF">1<span class="pl pF">F</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac">4<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">nums[F]=1 &ne; nums[S]=0 &rarr; new value! S++, nums[S]=1, F++</span></div>
<div class="wstep"><span class="wstep-n">Step 3</span><div><div class="arow"><span class="abk">[</span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac aS">1<span class="pl pS">S</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac aF">1<span class="pl pF">F</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac">4<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">nums[F]=1 == nums[S]=1 &rarr; duplicate, skip. F++</span></div>
<div class="wstep"><span class="wstep-n">Step 4</span><div><div class="arow"><span class="abk">[</span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac aS">1<span class="pl pS">S</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac aF">2<span class="pl pF">F</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac">4<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">nums[F]=2 &ne; nums[S]=1 &rarr; S++, nums[S]=2, F++. (Continues for 3 and 4 similarly)</span></div>
<div class="wstep"><span class="wstep-n">Done</span><div><div class="arow"><span class="abk">[</span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac aS">4<span class="pl pS">S</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac">4<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">F exhausted. Return S+1 = 5. Elements after index S are ignored.</span></div>
</div>"""
),

# ── P06 ──────────────────────────────────────────────────────
dict(
num="P06", filename="P06_SortColors",
title="Sort Colors (Dutch National Flag)",
lc=75, diff="Medium", dtype="Three Pointer",
problem="""
<p>Given an array of 0s, 1s, and 2s (colors red/white/blue), sort them in-place in a <strong>single pass</strong>. Do not use <code>Arrays.sort()</code>.</p>
<p><strong>Example:</strong> <code>[2,0,2,1,1,0]</code> &rarr; <code>[0,0,1,1,2,2]</code></p>
""",
layman="""
<p>Picture three buckets at the ends and middle of the array. <code>low</code> is the boundary of where 0s end. <code>high</code> is where 2s start. <code>mid</code> is the scanner. Rules: if <code>mid</code> sees a 0, swap it left to <code>low</code> and advance both. If it sees a 2, swap it right to <code>high</code> and only shrink <code>high</code> (don't advance <code>mid</code> — the swapped-in value is unknown). If it sees a 1, just advance <code>mid</code>.</p>
""",
aha="Two pointers aren't enough for three categories. Use three boundaries. After swapping a 2 to the right, don't advance mid — the swapped-in value hasn't been inspected yet.",
visual="""[2, 0, 2, 1, 1, 0]    low=0, mid=0, high=5

mid=0, nums[mid]=2 → swap(mid,high), high--    [0, 0, 2, 1, 1, 2]  mid stays at 0
mid=0, nums[mid]=0 → swap(mid,low), low++,mid++ [0, 0, 2, 1, 1, 2]
mid=1, nums[mid]=0 → swap(mid,low), low++,mid++ [0, 0, 2, 1, 1, 2]
mid=2, nums[mid]=2 → swap(mid,high), high--    [0, 0, 1, 1, 2, 2]  mid stays at 2
mid=2, nums[mid]=1 → mid++                      mid=3
mid=3, nums[mid]=1 → mid++                      mid=4  (mid&gt;high → DONE)
Result: [0, 0, 1, 1, 2, 2] ✓""",
algo=[
    "Set <code>low=0</code>, <code>mid=0</code>, <code>high=n-1</code>.",
    "While <code>mid &lt;= high</code>:",
    "&nbsp;&nbsp;If <code>nums[mid]==0</code>: swap <code>mid</code> and <code>low</code>, then <code>low++</code>, <code>mid++</code>.",
    "&nbsp;&nbsp;If <code>nums[mid]==1</code>: just <code>mid++</code>.",
    "&nbsp;&nbsp;If <code>nums[mid]==2</code>: swap <code>mid</code> and <code>high</code>, then <code>high--</code> only (mid stays).",
],
java="""public void sortColors(int[] nums) {
    int low = 0, mid = 0, high = nums.length - 1;
    while (mid &lt;= high) {
        if      (nums[mid] == 0) swap(nums, low++, mid++);
        else if (nums[mid] == 1) mid++;
        else                     swap(nums, mid, high--);  // do NOT mid++ here
    }
}
private void swap(int[] a, int i, int j) {
    int t = a[i]; a[i] = a[j]; a[j] = t;
}""",
time="O(n)", space="O(1)",
pattern="Three-pointer partition. A clever extension of two-pointer for three-category problems — one region is always the 'uncertain middle' that shrinks as mid advances.",
key="Don't advance mid after swapping a 2 — the value that came in from the right hasn't been classified yet.",
walk_html="""<div class="walk">
<div class="walk-title">Trace — green=low(S) &nbsp;|&nbsp; orange=mid(F) &nbsp;|&nbsp; indigo=high(H) &nbsp;|&nbsp; array=[2,0,2,1,1,0]</div>
<div class="wstep"><span class="wstep-n">Start</span><div><div class="arow"><span class="abk">[</span><span class="ac aS aF">2<span class="pl pS">S/F</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac aH">0<span class="pl pH">H</span></span><span class="abk">]</span></div></div><span class="wstep-act">low=0, mid=0, high=5</span></div>
<div class="wstep"><span class="wstep-n">Step 1</span><div><div class="arow"><span class="abk">[</span><span class="ac aF">0<span class="pl pF">F</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac aH">1<span class="pl pH">H</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">mid=2 &rarr; swap(mid,high), high=4. mid stays! (swapped-in value unknown)</span></div>
<div class="wstep"><span class="wstep-n">Step 2</span><div><div class="arow"><span class="abk">[</span><span class="ac aS aF">0<span class="pl pS">S/F</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac aH">1<span class="pl pH">H</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">mid=0 &rarr; swap(mid,low), low=1, mid=1</span></div>
<div class="wstep"><span class="wstep-n">Step 3</span><div><div class="arow"><span class="abk">[</span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac aS aF">0<span class="pl pS">S/F</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac aH">1<span class="pl pH">H</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">mid=0 &rarr; swap(mid,low), low=2, mid=2</span></div>
<div class="wstep"><span class="wstep-n">Step 4</span><div><div class="arow"><span class="abk">[</span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac aS aF">2<span class="pl pS">S/F</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac aH">1<span class="pl pH">H</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">mid=2 &rarr; swap(mid,high), high=3. mid stays at 2!</span></div>
<div class="wstep"><span class="wstep-n">Step 5</span><div><div class="arow"><span class="abk">[</span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac aS aF">1<span class="pl pS">S/F</span></span><span class="ac aH">1<span class="pl pH">H</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">mid=1 &rarr; mid++ only (already in middle zone)</span></div>
<div class="wstep"><span class="wstep-n">Done</span><div><div class="arow"><span class="abk">[</span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">mid=4 &gt; high=3 &rarr; loop ends. Result: [0,0,1,1,2,2]</span></div>
</div>"""
),

# ── P07 ──────────────────────────────────────────────────────
dict(
num="P07", filename="P07_MoveZeroes",
title="Move Zeroes",
lc=283, diff="Easy", dtype="Slow + Fast",
problem="""
<p>Given an integer array <code>nums</code>, move all <code>0</code>s to the end while maintaining the relative order of non-zero elements. Do it <strong>in-place</strong>.</p>
<p><strong>Example:</strong> <code>[0,1,0,3,12]</code> &rarr; <code>[1,3,12,0,0]</code></p>
""",
layman="""
<p>Think of the slow pointer as a parking spot for the next non-zero number. Fast scans the array. Every time it finds a non-zero, it parks it at slow's spot and moves slow forward. After fast finishes, fill the remaining positions with zeros.</p>
""",
aha="Same slow/fast template as Remove Duplicates/Remove Element — slow is the write head, fast is the reader. Here 'good' means non-zero.",
visual="""[0,  1,  0,  3, 12]
 S   F                      nums[F]=1 != 0 → nums[S]=1, S++, F++

[1,  1,  0,  3, 12]
     S       F              nums[F]=0 → just F++ (skip)

[1,  1,  0,  3, 12]
     S          F           nums[F]=3 → nums[S]=3, S++, F++

[1,  3,  0,  3, 12]
         S         F        nums[F]=12 → nums[S]=12, S++, F++

[1,  3, 12,  3, 12]
             S              F exhausted → fill nums[S..end] with 0

Result: [1, 3, 12, 0, 0] ✓""",
algo=[
    "Set <code>slow = 0</code>.",
    "Loop <code>fast</code> from 0 to <code>n-1</code>: if <code>nums[fast] != 0</code>, write <code>nums[slow] = nums[fast]</code> and <code>slow++</code>.",
    "After the loop, fill <code>nums[slow]</code> to <code>nums[n-1]</code> with zeros.",
],
java="""public void moveZeroes(int[] nums) {
    int slow = 0;
    for (int fast = 0; fast &lt; nums.length; fast++) {
        if (nums[fast] != 0) nums[slow++] = nums[fast];
    }
    while (slow &lt; nums.length) nums[slow++] = 0;
}""",
time="O(n)", space="O(1)",
pattern="Identical slow+fast template to Remove Duplicates. What changes is the condition: write when non-zero. Then pad the tail with zeros.",
key="Copy all non-zeros to the front (slow), then zero-fill the tail. One pass + one fill.",
walk_html="""<div class="walk">
<div class="walk-title">Trace — green=S (write head) &nbsp;|&nbsp; orange=F (scanner) &nbsp;|&nbsp; array=[0,1,0,3,12]</div>
<div class="wstep"><span class="wstep-n">Start</span><div><div class="arow"><span class="abk">[</span><span class="ac aS aF">0<span class="pl pS">S/F</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac">12<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">S=0, F=0 &mdash; both at index 0</span></div>
<div class="wstep"><span class="wstep-n">Step 1</span><div><div class="arow"><span class="abk">[</span><span class="ac aS">0<span class="pl pS">S</span></span><span class="ac aF">1<span class="pl pF">F</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac">12<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">nums[F]=0 &rarr; zero, skip. F++ only (S stays)</span></div>
<div class="wstep"><span class="wstep-n">Step 2</span><div><div class="arow"><span class="abk">[</span><span class="ac aS">1<span class="pl pS">S</span></span><span class="ac aF">1<span class="pl pF">F</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac">12<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">nums[F]=1 &rarr; good! Write nums[S]=1, S++, F++ (array[0] is now 1)</span></div>
<div class="wstep"><span class="wstep-n">Step 3</span><div><div class="arow"><span class="abk">[</span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac aS">3<span class="pl pS">S</span></span><span class="ac aF">0<span class="pl pF">F</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac">12<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">nums[F]=0 &rarr; zero, skip. F++ (S stays at 1)</span></div>
<div class="wstep"><span class="wstep-n">Step 4</span><div><div class="arow"><span class="abk">[</span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac aS">3<span class="pl pS">S</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac aF">3<span class="pl pF">F</span></span><span class="ac">12<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">nums[F]=3 &rarr; good! Write nums[S]=3, S++, F++</span></div>
<div class="wstep"><span class="wstep-n">Step 5</span><div><div class="arow"><span class="abk">[</span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac aS">12<span class="pl pS">S</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac aF">12<span class="pl pF">F</span></span><span class="abk">]</span></div></div><span class="wstep-act">nums[F]=12 &rarr; good! Write nums[S]=12, S++, F++ (F past end, loop done)</span></div>
<div class="wstep"><span class="wstep-n">Done</span><div><div class="arow"><span class="abk">[</span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac">12<span class="pl">&nbsp;</span></span><span class="ac aW">0<span class="pl">&nbsp;</span></span><span class="ac aW">0<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">Fill positions S&rarr;end with zeros. Result: [1,3,12,0,0]</span></div>
</div>"""
),

# ── P08 ──────────────────────────────────────────────────────
dict(
num="P08", filename="P08_SquaresOfSortedArray",
title="Squares of a Sorted Array",
lc=977, diff="Easy", dtype="Fill From Back",
problem="""
<p>Given an integer array sorted in <strong>non-decreasing order</strong> (may include negatives), return an array of the <strong>squares</strong> of each number, also sorted in non-decreasing order.</p>
<p><strong>Example:</strong> <code>[-4,-1,0,3,10]</code> &rarr; <code>[0,1,9,16,100]</code></p>
""",
layman="""
<p>Squaring a negative makes it positive, and large negatives square to huge values. So the largest squares are always at the <em>two ends</em> of the sorted array (either the most-negative or the most-positive). Use two pointers at both ends, compare absolute values, and fill a result array from <strong>right to left</strong> (largest first). This avoids sorting after squaring.</p>
""",
aha="After squaring a sorted array, the largest values come from the two ends. Fill the result from the back by comparing the ends.",
visual="""[-4, -1,  0,  3, 10]
  L                   R     pos=4   |L|=4, |R|=10  → result[4]=100, R--

[-4, -1,  0,  3, 10]
  L             R    pos=3   |L|=4, |R|=3   → result[3]=16,  L++

[-4, -1,  0,  3, 10]
      L         R   pos=2   |L|=1, |R|=3   → result[2]=9,   R--

[-4, -1,  0,  3, 10]
      L     R       pos=1   |L|=1, |R|=0   → result[1]=1,   L++

[-4, -1,  0,  3, 10]
          L  R      pos=0   |L|=0, |R|=0   → result[0]=0
Result: [0, 1, 9, 16, 100] ✓""",
algo=[
    "Set <code>left=0</code>, <code>right=n-1</code>, <code>pos=n-1</code>.",
    "While <code>left &lt;= right</code>: compare <code>|nums[left]|</code> vs <code>|nums[right]|</code>.",
    "Write the <strong>larger</strong> square at <code>result[pos--]</code>.",
    "Advance the pointer whose absolute value was larger.",
],
java="""public int[] sortedSquares(int[] nums) {
    int n = nums.length, left = 0, right = n - 1, pos = n - 1;
    int[] result = new int[n];
    while (left &lt;= right) {
        int lSq = nums[left]  * nums[left];
        int rSq = nums[right] * nums[right];
        if (lSq &gt; rSq) { result[pos--] = lSq; left++;  }
        else            { result[pos--] = rSq; right--; }
    }
    return result;
}""",
time="O(n)", space="O(n) for result",
pattern="Fill-from-back two-pointer. The key insight is that the two extremes of a sorted array hold the largest squares, so you build the answer array in reverse.",
key="Largest squares are always at the two ends. Fill result from right to left.",
walk_html="""<div class="walk">
<div class="walk-title">Trace — blue=L &nbsp;|&nbsp; red=R &nbsp;|&nbsp; pos fills result right-to-left &nbsp;|&nbsp; source: [-4,-1,0,3,10]</div>
<div class="wstep"><span class="wstep-n">Start</span><div>
  <div style="font-size:.74rem;color:#64748b;font-family:monospace;margin-bottom:3px">source:</div>
  <div class="arow"><span class="abk">[</span><span class="ac aL">-4<span class="pl pL">L</span></span><span class="ac">-1<span class="pl">&nbsp;</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac aR">10<span class="pl pR">R</span></span><span class="abk">]</span></div>
  <div style="font-size:.74rem;color:#64748b;font-family:monospace;margin-top:5px;margin-bottom:3px">result (pos=4):</div>
  <div class="arow"><span class="abk">[</span><span class="ac">_<span class="pl">&nbsp;</span></span><span class="ac">_<span class="pl">&nbsp;</span></span><span class="ac">_<span class="pl">&nbsp;</span></span><span class="ac">_<span class="pl">&nbsp;</span></span><span class="ac">_<span class="pl">&nbsp;</span></span><span class="abk">]</span></div>
</div><span class="wstep-act">|L|=4, |R|=10</span></div>
<div class="wstep"><span class="wstep-n">Step 1</span><div>
  <div class="arow"><span class="abk">[</span><span class="ac aL">-4<span class="pl pL">L</span></span><span class="ac">-1<span class="pl">&nbsp;</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac aR">10<span class="pl pR">R</span></span><span class="abk">]</span></div>
  <div class="arow" style="margin-top:5px"><span class="abk">[</span><span class="ac">_<span class="pl">&nbsp;</span></span><span class="ac">_<span class="pl">&nbsp;</span></span><span class="ac">_<span class="pl">&nbsp;</span></span><span class="ac">_<span class="pl">&nbsp;</span></span><span class="ac aW">100<span class="pl">&nbsp;</span></span><span class="abk">]</span></div>
</div><span class="wstep-act">|R|=10 &gt; |L|=4 &rarr; write 10&sup2;=100 at result[4]. R--, pos--</span></div>
<div class="wstep"><span class="wstep-n">Step 2</span><div>
  <div class="arow"><span class="abk">[</span><span class="ac aL">-4<span class="pl pL">L</span></span><span class="ac">-1<span class="pl">&nbsp;</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac aR">3<span class="pl pR">R</span></span><span class="ac">10<span class="pl">&nbsp;</span></span><span class="abk">]</span></div>
  <div class="arow" style="margin-top:5px"><span class="abk">[</span><span class="ac">_<span class="pl">&nbsp;</span></span><span class="ac">_<span class="pl">&nbsp;</span></span><span class="ac">_<span class="pl">&nbsp;</span></span><span class="ac aW">16<span class="pl">&nbsp;</span></span><span class="ac aW">100<span class="pl">&nbsp;</span></span><span class="abk">]</span></div>
</div><span class="wstep-act">|L|=4 &gt; |R|=3 &rarr; write (-4)&sup2;=16 at result[3]. L++, pos--</span></div>
<div class="wstep"><span class="wstep-n">Step 3</span><div>
  <div class="arow"><span class="abk">[</span><span class="ac">-4<span class="pl">&nbsp;</span></span><span class="ac aL">-1<span class="pl pL">L</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac aR">3<span class="pl pR">R</span></span><span class="ac">10<span class="pl">&nbsp;</span></span><span class="abk">]</span></div>
  <div class="arow" style="margin-top:5px"><span class="abk">[</span><span class="ac">_<span class="pl">&nbsp;</span></span><span class="ac">_<span class="pl">&nbsp;</span></span><span class="ac aW">9<span class="pl">&nbsp;</span></span><span class="ac aW">16<span class="pl">&nbsp;</span></span><span class="ac aW">100<span class="pl">&nbsp;</span></span><span class="abk">]</span></div>
</div><span class="wstep-act">|R|=3 &gt; |L|=1 &rarr; write 3&sup2;=9 at result[2]. R--, pos--</span></div>
<div class="wstep"><span class="wstep-n">Done</span><div>
  <div class="arow" style="margin-top:5px"><span class="abk">[</span><span class="ac aW">0<span class="pl">&nbsp;</span></span><span class="ac aW">1<span class="pl">&nbsp;</span></span><span class="ac aW">9<span class="pl">&nbsp;</span></span><span class="ac aW">16<span class="pl">&nbsp;</span></span><span class="ac aW">100<span class="pl">&nbsp;</span></span><span class="abk">]</span></div>
</div><span class="wstep-act">Steps 4-5 fill 1 and 0. Final result: [0,1,9,16,100]</span></div>
</div>"""
),

# ── P09 ──────────────────────────────────────────────────────
dict(
num="P09", filename="P09_ValidPalindrome",
title="Valid Palindrome",
lc=125, diff="Easy", dtype="Opposite Ends",
problem="""
<p>A phrase is a palindrome if it reads the same forward and backward after converting all uppercase to lowercase and removing all non-alphanumeric characters. Given string <code>s</code>, return <code>true</code> if it is a palindrome.</p>
<p><strong>Example:</strong> <code>"A man, a plan, a canal: Panama"</code> &rarr; <code>true</code></p>
""",
layman="""
<p>Put one finger at the start and one at the end of the string. Skip non-letters/digits (spaces, commas, colons). Compare the characters your fingers land on. If they ever differ, it's not a palindrome. If the fingers meet without any mismatch, it is a palindrome.</p>
""",
aha="Palindrome check = converging two-pointer from both ends, skip non-alphanumeric, compare case-insensitively.",
visual=""""A man, a plan, a canal: Panama"
 L                              R   A vs a → match (case-insensitive), L++, R--

  L                            R   ' ' → skip L;   skip commas/spaces on R too
  L                        R       m vs m → match
     L                     R       a vs a → match
     ...same pattern until L &gt;= R → true""",
algo=[
    "Set <code>left=0</code>, <code>right=s.length()-1</code>.",
    "While <code>left &lt; right</code>: skip non-alphanumeric on both sides.",
    "Compare <code>toLowerCase(s[left])</code> vs <code>toLowerCase(s[right])</code>. If they differ, return <code>false</code>.",
    "<code>left++</code>, <code>right--</code>.",
    "Return <code>true</code>.",
],
java="""public boolean isPalindrome(String s) {
    int left = 0, right = s.length() - 1;
    while (left &lt; right) {
        while (left &lt; right &amp;&amp; !Character.isLetterOrDigit(s.charAt(left)))  left++;
        while (left &lt; right &amp;&amp; !Character.isLetterOrDigit(s.charAt(right))) right--;
        if (Character.toLowerCase(s.charAt(left)) !=
            Character.toLowerCase(s.charAt(right))) return false;
        left++; right--;
    }
    return true;
}""",
time="O(n)", space="O(1)",
pattern="Purest converging two-pointer: compare from both ends toward center. Works on strings, arrays, linked lists.",
key="Skip non-alphanumeric on both ends, compare case-insensitively, converge until pointers meet.",
walk_html="""<div class="walk">
<div class="walk-title">Trace — blue=L &nbsp;|&nbsp; red=R &nbsp;|&nbsp; string="racecar" (skip non-alphanumeric, compare case-insensitive)</div>
<div class="wstep"><span class="wstep-n">Start</span><div><div class="arow"><span class="abk">[</span><span class="ac aL">r<span class="pl pL">L</span></span><span class="ac">a<span class="pl">&nbsp;</span></span><span class="ac">c<span class="pl">&nbsp;</span></span><span class="ac">e<span class="pl">&nbsp;</span></span><span class="ac">c<span class="pl">&nbsp;</span></span><span class="ac">a<span class="pl">&nbsp;</span></span><span class="ac aR">r<span class="pl pR">R</span></span><span class="abk">]</span></div></div><span class="wstep-act">L=0 ('r'), R=6 ('r'). 'r'=='r' &rarr; match! L++, R--</span></div>
<div class="wstep"><span class="wstep-n">Step 1</span><div><div class="arow"><span class="abk">[</span><span class="ac">r<span class="pl">&nbsp;</span></span><span class="ac aL">a<span class="pl pL">L</span></span><span class="ac">c<span class="pl">&nbsp;</span></span><span class="ac">e<span class="pl">&nbsp;</span></span><span class="ac">c<span class="pl">&nbsp;</span></span><span class="ac aR">a<span class="pl pR">R</span></span><span class="ac">r<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">L=1 ('a'), R=5 ('a'). 'a'=='a' &rarr; match! L++, R--</span></div>
<div class="wstep"><span class="wstep-n">Step 2</span><div><div class="arow"><span class="abk">[</span><span class="ac">r<span class="pl">&nbsp;</span></span><span class="ac">a<span class="pl">&nbsp;</span></span><span class="ac aL">c<span class="pl pL">L</span></span><span class="ac">e<span class="pl">&nbsp;</span></span><span class="ac aR">c<span class="pl pR">R</span></span><span class="ac">a<span class="pl">&nbsp;</span></span><span class="ac">r<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">L=2 ('c'), R=4 ('c'). 'c'=='c' &rarr; match! L++, R--</span></div>
<div class="wstep"><span class="wstep-n">Step 3</span><div><div class="arow"><span class="abk">[</span><span class="ac">r<span class="pl">&nbsp;</span></span><span class="ac">a<span class="pl">&nbsp;</span></span><span class="ac">c<span class="pl">&nbsp;</span></span><span class="ac aL aR">e<span class="pl" style="color:#a78bfa">L=R</span></span><span class="ac">c<span class="pl">&nbsp;</span></span><span class="ac">a<span class="pl">&nbsp;</span></span><span class="ac">r<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">L=3, R=3. L&ge;R &rarr; loop ends. Return true &mdash; it IS a palindrome!</span></div>
</div>"""
),

# ── P10 ──────────────────────────────────────────────────────
dict(
num="P10", filename="P10_ReverseString",
title="Reverse String",
lc=344, diff="Easy", dtype="Opposite Ends",
problem="""
<p>Write a function that reverses a character array <code>s</code> in-place. Do it with O(1) extra memory.</p>
<p><strong>Example:</strong> <code>['h','e','l','l','o']</code> &rarr; <code>['o','l','l','e','h']</code></p>
""",
layman="""
<p>The simplest two-pointer problem. Swap the outermost characters, then move both pointers inward, repeat until they meet. Like flipping a pancake — you always take the two outermost and switch them.</p>
""",
aha="This is the simplest two-pointer pattern: swap outermost pair, converge, repeat. It's the building block of many harder reverse/palindrome problems.",
visual="""['h','e','l','l','o']
  L               R       swap h&harr;o → ['o','e','l','l','h']
      L       R           swap e&harr;l → ['o','l','l','e','h']
          L               L==R → stop
Result: ['o','l','l','e','h'] ✓""",
algo=[
    "Set <code>left=0</code>, <code>right=n-1</code>.",
    "While <code>left &lt; right</code>: swap <code>s[left]</code> and <code>s[right]</code>, then <code>left++</code>, <code>right--</code>.",
],
java="""public void reverseString(char[] s) {
    int left = 0, right = s.length - 1;
    while (left &lt; right) {
        char tmp  = s[left];
        s[left++] = s[right];
        s[right--] = tmp;
    }
}""",
time="O(n)", space="O(1)",
pattern="Foundational swap-from-ends two-pointer. This exact loop appears inside Valid Palindrome, Sort Colors, and any in-place reversal.",
key="Swap outermost pair, converge. Stop when left >= right.",
walk_html="""<div class="walk">
<div class="walk-title">Trace — blue=L &nbsp;|&nbsp; red=R &nbsp;|&nbsp; swap outermost pair, converge &nbsp;|&nbsp; ['h','e','l','l','o']</div>
<div class="wstep"><span class="wstep-n">Start</span><div><div class="arow"><span class="abk">[</span><span class="ac aL">h<span class="pl pL">L</span></span><span class="ac">e<span class="pl">&nbsp;</span></span><span class="ac">l<span class="pl">&nbsp;</span></span><span class="ac">l<span class="pl">&nbsp;</span></span><span class="ac aR">o<span class="pl pR">R</span></span><span class="abk">]</span></div></div><span class="wstep-act">L=0, R=4 — place at both ends</span></div>
<div class="wstep"><span class="wstep-n">Step 1</span><div><div class="arow"><span class="abk">[</span><span class="ac aL">o<span class="pl pL">L</span></span><span class="ac">e<span class="pl">&nbsp;</span></span><span class="ac">l<span class="pl">&nbsp;</span></span><span class="ac">l<span class="pl">&nbsp;</span></span><span class="ac aR">h<span class="pl pR">R</span></span><span class="abk">]</span></div></div><span class="wstep-act">Swap s[L]&harr;s[R]: 'h' &harr; 'o'. L++, R--</span></div>
<div class="wstep"><span class="wstep-n">Step 2</span><div><div class="arow"><span class="abk">[</span><span class="ac">o<span class="pl">&nbsp;</span></span><span class="ac aL">l<span class="pl pL">L</span></span><span class="ac">l<span class="pl">&nbsp;</span></span><span class="ac aR">e<span class="pl pR">R</span></span><span class="ac">h<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">Swap s[L]&harr;s[R]: 'e' &harr; 'l'. L++, R--</span></div>
<div class="wstep"><span class="wstep-n">Done</span><div><div class="arow"><span class="abk">[</span><span class="ac">o<span class="pl">&nbsp;</span></span><span class="ac">l<span class="pl">&nbsp;</span></span><span class="ac aL aR">l<span class="pl" style="color:#a78bfa">L=R</span></span><span class="ac">e<span class="pl">&nbsp;</span></span><span class="ac">h<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">L=2, R=2. L&ge;R &rarr; stop. Result: ['o','l','l','e','h']</span></div>
</div>"""
),

# ── P11 ──────────────────────────────────────────────────────
dict(
num="P11", filename="P11_ThreeSumClosest",
title="3Sum Closest",
lc=16, diff="Medium", dtype="Fix One + Two Pointer",
problem="""
<p>Given an integer array <code>nums</code> and integer <code>target</code>, find three integers whose sum is <strong>closest to</strong> <code>target</code>. Return that sum.</p>
<p><strong>Example:</strong> <code>nums=[-1,2,1,-4], target=1</code> &rarr; <code>2</code> (sum of -1+2+1)</p>
""",
layman="""
<p>Same structure as 3Sum (fix i, two-pointer the rest), but instead of looking for exact zero, you track the <em>closest sum seen so far</em>. Every time you compute a triplet sum, check if it's closer to target than your current best. Move pointers the same way: sum too small → left++, too large → right--, exact match → return immediately.</p>
""",
aha="3Sum Closest = 3Sum with a 'closest distance tracker' instead of an exact-match check. The pointer movement logic is identical.",
visual="""Sorted: [-4, -1, 1, 2], target=1

i=0 (nums[i]=-4), left=1, right=3:
  sum=-4+-1+2=-3  |−3−1|=4, closest=-3. -3&lt;1 → left++
  sum=-4+1+2=-1   |−1−1|=2, closest=-1. -1&lt;1 → left++
  left&gt;=right → move i

i=1 (nums[i]=-1), left=2, right=3:
  sum=-1+1+2=2    |2−1|=1, closest=2.  2&gt;1 → right--
  left&gt;=right → move i

Return closest = 2 ✓""",
algo=[
    "Sort <code>nums</code>. Initialize <code>closest = nums[0]+nums[1]+nums[2]</code>.",
    "Loop <code>i</code> from 0 to <code>n-3</code>.",
    "Set <code>left=i+1</code>, <code>right=n-1</code>. Run Two Pointer:",
    "Compute <code>sum = nums[i]+nums[left]+nums[right]</code>. Update <code>closest</code> if <code>|sum-target| &lt; |closest-target|</code>.",
    "If <code>sum &lt; target</code>: <code>left++</code>. If <code>sum &gt; target</code>: <code>right--</code>. If exact: return <code>sum</code>.",
],
java="""public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int closest = nums[0] + nums[1] + nums[2];
    for (int i = 0; i &lt; nums.length - 2; i++) {
        int left = i + 1, right = nums.length - 1;
        while (left &lt; right) {
            int sum = nums[i] + nums[left] + nums[right];
            if (Math.abs(sum - target) &lt; Math.abs(closest - target)) closest = sum;
            if      (sum &lt; target) left++;
            else if (sum &gt; target) right--;
            else return sum;   // exact match
        }
    }
    return closest;
}""",
time="O(n²)", space="O(1) extra",
pattern="Fix + Two Pointer with a 'best-so-far' tracker instead of a collision check. Structurally identical to 3Sum.",
key="Track closest instead of checking for exact zero. Pointer movement is exactly the same as 3Sum.",
walk_html="""<div class="walk">
<div class="walk-title">Trace — purple=i (fixed) &nbsp;|&nbsp; blue=L &nbsp;|&nbsp; red=R &nbsp;|&nbsp; sorted: [-4,-1,1,2], target=1</div>
<div class="wstep"><span class="wstep-n">Sort</span><div><div class="arow"><span class="abk">[</span><span class="ac">-4<span class="pl">&nbsp;</span></span><span class="ac">-1<span class="pl">&nbsp;</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">Sort first. Initial closest = -4-1+1 = -4</span></div>
<div class="wstep"><span class="wstep-n">i=0</span><div><div class="arow"><span class="abk">[</span><span class="ac ai">-4<span class="pl pi">i</span></span><span class="ac aL">-1<span class="pl pL">L</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac aR">2<span class="pl pR">R</span></span><span class="abk">]</span></div></div><span class="wstep-act">sum=-4-1+2=-3. |-3-1|=4 &lt; |-4-1|=5 &rarr; closest=-3. sum&lt;1 &rarr; L++</span></div>
<div class="wstep"><span class="wstep-n">i=0</span><div><div class="arow"><span class="abk">[</span><span class="ac ai">-4<span class="pl pi">i</span></span><span class="ac">-1<span class="pl">&nbsp;</span></span><span class="ac aL">1<span class="pl pL">L</span></span><span class="ac aR">2<span class="pl pR">R</span></span><span class="abk">]</span></div></div><span class="wstep-act">sum=-4+1+2=-1. |-1-1|=2 &lt; |-3-1|=4 &rarr; closest=-1. sum&lt;1 &rarr; L++. L&ge;R, end inner</span></div>
<div class="wstep"><span class="wstep-n">i=1</span><div><div class="arow"><span class="abk">[</span><span class="ac">-4<span class="pl">&nbsp;</span></span><span class="ac ai">-1<span class="pl pi">i</span></span><span class="ac aL">1<span class="pl pL">L</span></span><span class="ac aR">2<span class="pl pR">R</span></span><span class="abk">]</span></div></div><span class="wstep-act">sum=-1+1+2=2. |2-1|=1 &lt; |-1-1|=2 &rarr; closest=2. sum&gt;1 &rarr; R--. L&ge;R, end inner</span></div>
<div class="wstep"><span class="wstep-n">Done</span><div style="color:#6ee7b7;font-family:monospace;font-size:.82rem;padding:8px 0">Return closest = 2</div><span class="wstep-act">i=2 would need 3 elements ahead — loop ends. Answer: 2 (closest to target=1)</span></div>
</div>"""
),

# ── P12 ──────────────────────────────────────────────────────
dict(
num="P12", filename="P12_FourSum",
title="4Sum",
lc=18, diff="Medium", dtype="Fix Two + Two Pointer",
problem="""
<p>Given integer array <code>nums</code> and integer <code>target</code>, return all unique quadruplets <code>[a,b,c,d]</code> such that <code>a+b+c+d == target</code>.</p>
<p><strong>Example:</strong> <code>[1,0,-1,0,-2,2], target=0</code> &rarr; <code>[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]</code></p>
""",
layman="""
<p>4Sum = fix two numbers (i and j), then run Two Sum II on the rest. Sort first, skip duplicates at every level. The pattern generalizes: k-Sum = fix one number + solve (k-1)-Sum recursively. You always bottom out at Two Pointer for the innermost Two Sum.</p>
""",
aha="4Sum = two nested loops (fix i, fix j) + Two Pointer inside. The deduplication logic mirrors 3Sum — skip whenever the current index equals the previous.",
visual="""Sorted: [-2,-1,0,0,1,2], target=0

i=0 (-2), j=1 (-1), left=2, right=5:  sum=-2-1+0+2=-1 &lt; 0 → left++
i=0 (-2), j=1 (-1), left=3, right=5:  sum=-2-1+0+2=-1 &lt; 0 → left++
i=0 (-2), j=1 (-1), left=4, right=5:  sum=-2-1+1+2=0  = 0 → save! skip dupes
i=0 (-2), j=2 ( 0), left=3, right=5:  sum=-2+0+0+2=0  = 0 → save! skip dupes
...""",
algo=[
    "Sort <code>nums</code>.",
    "Loop <code>i</code> from 0 to <code>n-4</code>; skip if duplicate.",
    "Loop <code>j</code> from <code>i+1</code> to <code>n-3</code>; skip if duplicate.",
    "Set <code>left=j+1</code>, <code>right=n-1</code>. Run Two Pointer for <code>target - nums[i] - nums[j]</code>.",
    "On match, save quadruplet, skip inner duplicates.",
],
java="""public List&lt;List&lt;Integer&gt;&gt; fourSum(int[] nums, int target) {
    List&lt;List&lt;Integer&gt;&gt; res = new ArrayList&lt;&gt;();
    Arrays.sort(nums);
    for (int i = 0; i &lt; nums.length - 3; i++) {
        if (i &gt; 0 &amp;&amp; nums[i] == nums[i-1]) continue;
        for (int j = i+1; j &lt; nums.length - 2; j++) {
            if (j &gt; i+1 &amp;&amp; nums[j] == nums[j-1]) continue;
            int left = j+1, right = nums.length - 1;
            while (left &lt; right) {
                long sum = (long)nums[i]+nums[j]+nums[left]+nums[right];
                if (sum == target) {
                    res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                    while (left &lt; right &amp;&amp; nums[left]  == nums[left+1])  left++;
                    while (left &lt; right &amp;&amp; nums[right] == nums[right-1]) right--;
                    left++; right--;
                } else if (sum &lt; target) left++;
                else                     right--;
            }
        }
    }
    return res;
}""",
time="O(n³)", space="O(1) extra",
pattern="Generalized k-Sum: nest (k-2) loops, two-pointer the innermost two. Use long to avoid integer overflow.",
key="4Sum = 3Sum + one more fixed loop. Cast to long to avoid overflow when summing large ints.",
walk_html="""<div class="walk">
<div class="walk-title">Trace — purple=i &nbsp;|&nbsp; indigo=j &nbsp;|&nbsp; blue=L &nbsp;|&nbsp; red=R &nbsp;|&nbsp; sorted: [-2,-1,0,0,1,2], target=0</div>
<div class="wstep"><span class="wstep-n">Sort</span><div><div class="arow"><span class="abk">[</span><span class="ac">-2<span class="pl">&nbsp;</span></span><span class="ac">-1<span class="pl">&nbsp;</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">Sort first. Fix i, then j, then two-pointer on the rest.</span></div>
<div class="wstep"><span class="wstep-n">i=0,j=1</span><div><div class="arow"><span class="abk">[</span><span class="ac ai">-2<span class="pl pi">i</span></span><span class="ac aH">-1<span class="pl pH">j</span></span><span class="ac aL">0<span class="pl pL">L</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac aR">2<span class="pl pR">R</span></span><span class="abk">]</span></div></div><span class="wstep-act">sum=-2-1+0+2=-1 &lt; 0 &rarr; L++</span></div>
<div class="wstep"><span class="wstep-n">i=0,j=1</span><div><div class="arow"><span class="abk">[</span><span class="ac ai">-2<span class="pl pi">i</span></span><span class="ac aH">-1<span class="pl pH">j</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac aL">0<span class="pl pL">L</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac aR">2<span class="pl pR">R</span></span><span class="abk">]</span></div></div><span class="wstep-act">sum=-2-1+0+2=-1 &lt; 0 &rarr; L++</span></div>
<div class="wstep"><span class="wstep-n">i=0,j=1</span><div><div class="arow"><span class="abk">[</span><span class="ac ai">-2<span class="pl pi">i</span></span><span class="ac aH">-1<span class="pl pH">j</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac">0<span class="pl">&nbsp;</span></span><span class="ac aL">1<span class="pl pL">L</span></span><span class="ac aR">2<span class="pl pR">R</span></span><span class="abk">]</span></div></div><span class="wstep-act">sum=-2-1+1+2=0 &rarr; FOUND! save [-2,-1,1,2]. Skip dupes, L++, R--. L&ge;R, end inner.</span></div>
<div class="wstep"><span class="wstep-n">i=0,j=2</span><div><div class="arow"><span class="abk">[</span><span class="ac ai">-2<span class="pl pi">i</span></span><span class="ac">-1<span class="pl">&nbsp;</span></span><span class="ac aH">0<span class="pl pH">j</span></span><span class="ac aL">0<span class="pl pL">L</span></span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac aR">2<span class="pl pR">R</span></span><span class="abk">]</span></div></div><span class="wstep-act">sum=-2+0+0+2=0 &rarr; FOUND! save [-2,0,0,2]. Continue finding more...</span></div>
<div class="wstep"><span class="wstep-n">Done</span><div style="color:#6ee7b7;font-family:monospace;font-size:.82rem;padding:8px 0">[[-2,-1,1,2], [-2,0,0,2], [-1,0,0,1]]</div><span class="wstep-act">All 3 unique quadruplets found in O(n&sup3;) time</span></div>
</div>"""
),

# ── P13 ──────────────────────────────────────────────────────
dict(
num="P13", filename="P13_BoatsToSavePeople",
title="Boats to Save People",
lc=881, diff="Medium", dtype="Opposite Ends",
problem="""
<p>Each boat can carry at most 2 people with a total weight &le; <code>limit</code>. Given a <code>people</code> array (weights), return the minimum number of boats required. Every person must be in a boat.</p>
<p><strong>Example:</strong> <code>[3,2,2,1], limit=3</code> &rarr; <code>3</code></p>
""",
layman="""
<p>Sort by weight. Always put the <strong>heaviest person</strong> in a boat. Then check if the <strong>lightest person</strong> can share. If they can, pair them (both pointers move). If not, the heavy person sails alone (only right pointer moves). Either way, one boat is used per iteration.</p>
""",
aha="Greedy + two pointer: always place the heaviest person. Then greedily try to pair with the lightest. This greedy choice is optimal — if the lightest can't pair with the heaviest, they can't pair with anyone heavier.",
visual="""Sorted: [1, 2, 2, 3],  limit=3

L=0(1), R=3(3): 1+3=4 &gt; 3  → R alone in boat 1, R--
L=0(1), R=2(2): 1+2=3 = 3  → pair! boat 2, L++, R--
L=1(2), R=1(2): L==R      → R alone in boat 3, R--
Total: 3 boats ✓""",
algo=[
    "Sort <code>people</code>.",
    "Set <code>left=0</code>, <code>right=n-1</code>, <code>boats=0</code>.",
    "While <code>left &lt;= right</code>: if <code>people[left]+people[right] &lt;= limit</code>, pair them: <code>left++</code>. Always: <code>right--</code>, <code>boats++</code>.",
],
java="""public int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);
    int left = 0, right = people.length - 1, boats = 0;
    while (left &lt;= right) {
        if (people[left] + people[right] &lt;= limit) left++;  // pair!
        right--;   // heaviest always gets a boat
        boats++;
    }
    return boats;
}""",
time="O(n log n)", space="O(1)",
pattern="Greedy + opposite-end two-pointer. The sort + greedy pairing guarantees minimum boats. Notice: right-- happens unconditionally every iteration.",
key="Heaviest person always gets a boat. Try to pair with lightest. If not, heaviest goes alone.",
walk_html="""<div class="walk">
<div class="walk-title">Trace — blue=L (lightest) &nbsp;|&nbsp; red=R (heaviest) &nbsp;|&nbsp; sorted: [1,2,2,3], limit=3</div>
<div class="wstep"><span class="wstep-n">Sort</span><div><div class="arow"><span class="abk">[</span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">Sort by weight first. boats=0</span></div>
<div class="wstep"><span class="wstep-n">Step 1</span><div><div class="arow"><span class="abk">[</span><span class="ac aL">1<span class="pl pL">L</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac aR">3<span class="pl pR">R</span></span><span class="abk">]</span></div></div><span class="wstep-act">1+3=4 &gt; limit=3 &rarr; heaviest (R) goes alone. boats=1. R--</span></div>
<div class="wstep"><span class="wstep-n">Step 2</span><div><div class="arow"><span class="abk">[</span><span class="ac aL">1<span class="pl pL">L</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac aR">2<span class="pl pR">R</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">1+2=3 &le; limit=3 &rarr; pair them! boats=2. L++, R--</span></div>
<div class="wstep"><span class="wstep-n">Step 3</span><div><div class="arow"><span class="abk">[</span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac aL aR">2<span class="pl" style="color:#a78bfa">L=R</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">L==R (one person left) &rarr; alone in a boat. boats=3. R--</span></div>
<div class="wstep"><span class="wstep-n">Done</span><div style="color:#6ee7b7;font-family:monospace;font-size:.82rem;padding:8px 0">Return 3 boats</div><span class="wstep-act">L&gt;R &rarr; loop ends. Minimum boats needed = 3</span></div>
</div>"""
),

# ── P14 ──────────────────────────────────────────────────────
dict(
num="P14", filename="P14_MergeSortedArray",
title="Merge Sorted Array",
lc=88, diff="Easy", dtype="Fill From Back",
problem="""
<p><code>nums1</code> has <code>m</code> elements followed by <code>n</code> zeros (space for merge). <code>nums2</code> has <code>n</code> elements. Merge <code>nums2</code> into <code>nums1</code> in sorted order, in-place.</p>
<p><strong>Example:</strong> <code>nums1=[1,2,3,0,0,0], m=3, nums2=[2,5,6], n=3</code> &rarr; <code>[1,2,2,3,5,6]</code></p>
""",
layman="""
<p>If you fill from the front, you'd overwrite elements you haven't compared yet. Instead, fill from the <strong>back</strong>. The back of nums1 is always free space. Compare the largest unplaced elements of both arrays and write the bigger one at the back. This avoids overwriting anything important.</p>
""",
aha="Fill from the back: the tail of nums1 is empty space. Writing the larger element there never overwrites data you still need.",
visual="""nums1=[1, 2, 3, 0, 0, 0]  m=3
nums2=[2, 5, 6]            n=3
         p1=2                  p2=2  p=5

p1=2(3), p2=2(6): 6&gt;3 → nums1[5]=6, p2--, p--   [1,2,3,0,0,6]
p1=2(3), p2=1(5): 5&gt;3 → nums1[4]=5, p2--, p--   [1,2,3,0,5,6]
p1=2(3), p2=0(2): 3&gt;2 → nums1[3]=3, p1--, p--   [1,2,3,3,5,6]
p1=1(2), p2=0(2): tie → nums1[2]=2, p2--, p--   [1,2,2,3,5,6]
p2&lt;0 → done ✓""",
algo=[
    "Set <code>p1=m-1</code>, <code>p2=n-1</code>, <code>p=m+n-1</code>.",
    "While both <code>p1&ge;0</code> and <code>p2&ge;0</code>: place the larger of <code>nums1[p1]</code> / <code>nums2[p2]</code> at <code>nums1[p--]</code>.",
    "If <code>p2</code> still has elements, copy them (if <code>p1</code> runs out first).",
],
java="""public void merge(int[] nums1, int m, int[] nums2, int n) {
    int p1 = m - 1, p2 = n - 1, p = m + n - 1;
    while (p1 &gt;= 0 &amp;&amp; p2 &gt;= 0) {
        if (nums1[p1] &gt; nums2[p2]) nums1[p--] = nums1[p1--];
        else                        nums1[p--] = nums2[p2--];
    }
    while (p2 &gt;= 0) nums1[p--] = nums2[p2--];  // remaining nums2
}""",
time="O(m+n)", space="O(1)",
pattern="Fill-from-back two-pointer. Classic trick whenever you have a pre-allocated tail of space: always fill from the back to avoid overwrites.",
key="Start from the end of both arrays and fill nums1 from the back. Leftover nums2 elements need to be copied; leftover nums1 elements are already in place.",
walk_html="""<div class="walk">
<div class="walk-title">Trace — blue=p1 &nbsp;|&nbsp; red=p2 &nbsp;|&nbsp; fill pos from right &nbsp;|&nbsp; nums1=[1,2,3,0,0,0], nums2=[2,5,6]</div>
<div class="wstep"><span class="wstep-n">Start</span><div>
  <div style="font-size:.74rem;color:#64748b;font-family:monospace;margin-bottom:3px">nums1:</div>
  <div class="arow"><span class="abk">[</span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac aL">3<span class="pl pL">p1</span></span><span class="ac">_<span class="pl">&nbsp;</span></span><span class="ac">_<span class="pl">&nbsp;</span></span><span class="ac">_<span class="pl">&nbsp;</span></span><span class="abk">]</span></div>
  <div style="font-size:.74rem;color:#64748b;font-family:monospace;margin-top:5px;margin-bottom:3px">nums2:</div>
  <div class="arow"><span class="abk">[</span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">5<span class="pl">&nbsp;</span></span><span class="ac aR">6<span class="pl pR">p2</span></span><span class="abk">]</span></div>
</div><span class="wstep-act">p1=2(val 3), p2=2(val 6), pos=5</span></div>
<div class="wstep"><span class="wstep-n">Step 1</span><div>
  <div class="arow"><span class="abk">[</span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac aL">3<span class="pl pL">p1</span></span><span class="ac">_<span class="pl">&nbsp;</span></span><span class="ac">_<span class="pl">&nbsp;</span></span><span class="ac aW">6<span class="pl">&nbsp;</span></span><span class="abk">]</span></div>
</div><span class="wstep-act">3 &lt; 6 &rarr; write nums2[p2]=6 at pos=5. p2--, pos--</span></div>
<div class="wstep"><span class="wstep-n">Step 2</span><div>
  <div class="arow"><span class="abk">[</span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac aL">3<span class="pl pL">p1</span></span><span class="ac">_<span class="pl">&nbsp;</span></span><span class="ac aW">5<span class="pl">&nbsp;</span></span><span class="ac aW">6<span class="pl">&nbsp;</span></span><span class="abk">]</span></div>
</div><span class="wstep-act">3 &lt; 5 &rarr; write nums2[p2]=5 at pos=4. p2--, pos--</span></div>
<div class="wstep"><span class="wstep-n">Step 3</span><div>
  <div class="arow"><span class="abk">[</span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac aL">2<span class="pl pL">p1</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac aW">3<span class="pl">&nbsp;</span></span><span class="ac aW">5<span class="pl">&nbsp;</span></span><span class="ac aW">6<span class="pl">&nbsp;</span></span><span class="abk">]</span></div>
</div><span class="wstep-act">3 &gt; 2 &rarr; write nums1[p1]=3 at pos=3. p1--, pos--</span></div>
<div class="wstep"><span class="wstep-n">Done</span><div>
  <div class="arow"><span class="abk">[</span><span class="ac aW">1<span class="pl">&nbsp;</span></span><span class="ac aW">2<span class="pl">&nbsp;</span></span><span class="ac aW">2<span class="pl">&nbsp;</span></span><span class="ac aW">3<span class="pl">&nbsp;</span></span><span class="ac aW">5<span class="pl">&nbsp;</span></span><span class="ac aW">6<span class="pl">&nbsp;</span></span><span class="abk">]</span></div>
</div><span class="wstep-act">Steps 4-5 write remaining 2(nums2) and 2,1(nums1). Final: [1,2,2,3,5,6]</span></div>
</div>"""
),

# ── P15 ──────────────────────────────────────────────────────
dict(
num="P15", filename="P15_BackspaceStringCompare",
title="Backspace String Compare",
lc=844, diff="Easy", dtype="Opposite Ends (Right-to-Left)",
problem="""
<p>Given two strings <code>s</code> and <code>t</code> where <code>#</code> means backspace, return <code>true</code> if the strings are equal after processing backspaces. Solve in <strong>O(1) space</strong>.</p>
<p><strong>Example:</strong> <code>s="ab#c", t="ad#c"</code> &rarr; <code>true</code> (both become "ac")</p>
""",
layman="""
<p>Process both strings from <strong>right to left</strong>. Keep a skip counter per string. Each <code>#</code> increments skip (next real char must be discarded). A non-# char with skip &gt; 0 decrements skip (discarded). A non-# char with skip=0 is a valid character to compare. Compare both strings' next valid characters; if they differ, return false.</p>
""",
aha="Right-to-left two pointer: walk backward, 'consuming' backspaces as skip counts. This avoids building a new string (O(1) space).",
visual="""s="ab#c"   t="ad#c"
i=3(c)  j=3(c): skip=0,0 → compare c vs c → match, i--, j--
i=2(#)  j=2(#): skipS++, i--; skipT++, j--   skipS=1, skipT=1
i=1(b)  j=1(d): skipS=1 → discard b, skipS--, i--
i=0(a)  j=1(d): skipT=1 → discard d, skipT--, j--
i=0(a)  j=0(a): skip=0,0 → compare a vs a → match, i--, j--
i&lt;0, j&lt;0 → return true ✓""",
algo=[
    "Set <code>i=s.length()-1</code>, <code>j=t.length()-1</code>, <code>skipS=0</code>, <code>skipT=0</code>.",
    "While <code>i&ge;0</code> or <code>j&ge;0</code>: advance each pointer past any backspaced characters.",
    "Compare the characters (or check if one string ran out first). If mismatch, return false.",
    "If both out at same time, return true.",
],
java="""public boolean backspaceCompare(String s, String t) {
    int i = s.length()-1, j = t.length()-1, skipS = 0, skipT = 0;
    while (i &gt;= 0 || j &gt;= 0) {
        while (i &gt;= 0) {
            if      (s.charAt(i) == '#') { skipS++; i--; }
            else if (skipS &gt; 0)          { skipS--; i--; }
            else break;
        }
        while (j &gt;= 0) {
            if      (t.charAt(j) == '#') { skipT++; j--; }
            else if (skipT &gt; 0)          { skipT--; j--; }
            else break;
        }
        if (i &gt;= 0 &amp;&amp; j &gt;= 0 &amp;&amp; s.charAt(i) != t.charAt(j)) return false;
        if ((i &gt;= 0) != (j &gt;= 0)) return false;
        i--; j--;
    }
    return true;
}""",
time="O(n+m)", space="O(1)",
pattern="Right-to-left two-pointer with a skip counter acting as a virtual 'consumed backspace' tracker. Avoids materializing the processed strings.",
key="Walk backward, use skip count to skip over backspaced characters without building the actual string.",
walk_html="""<div class="walk">
<div class="walk-title">Trace — walk right-to-left &nbsp;|&nbsp; s="ab#c", t="ad#c" &nbsp;|&nbsp; # means backspace</div>
<div class="wstep"><span class="wstep-n">Start</span><div>
  <div style="font-size:.74rem;color:#64748b;font-family:monospace;margin-bottom:3px">s:</div>
  <div class="arow"><span class="abk">[</span><span class="ac">a<span class="pl">&nbsp;</span></span><span class="ac">b<span class="pl">&nbsp;</span></span><span class="ac">#<span class="pl">&nbsp;</span></span><span class="ac aL">c<span class="pl pL">i</span></span><span class="abk">]</span></div>
  <div style="font-size:.74rem;color:#64748b;font-family:monospace;margin-top:5px;margin-bottom:3px">t:</div>
  <div class="arow"><span class="abk">[</span><span class="ac">a<span class="pl">&nbsp;</span></span><span class="ac">d<span class="pl">&nbsp;</span></span><span class="ac">#<span class="pl">&nbsp;</span></span><span class="ac aR">c<span class="pl pR">j</span></span><span class="abk">]</span></div>
</div><span class="wstep-act">i=3 (c), j=3 (c). skipS=0, skipT=0</span></div>
<div class="wstep"><span class="wstep-n">Step 1</span><div>
  <div class="arow"><span class="abk">[</span><span class="ac">a<span class="pl">&nbsp;</span></span><span class="ac">b<span class="pl">&nbsp;</span></span><span class="ac aL">#<span class="pl pL">i</span></span><span class="ac">c<span class="pl">&nbsp;</span></span><span class="abk">]</span></div>
  <div class="arow" style="margin-top:5px"><span class="abk">[</span><span class="ac">a<span class="pl">&nbsp;</span></span><span class="ac">d<span class="pl">&nbsp;</span></span><span class="ac aR">#<span class="pl pR">j</span></span><span class="ac">c<span class="pl">&nbsp;</span></span><span class="abk">]</span></div>
</div><span class="wstep-act">s[i]='c', t[j]='c' &rarr; match! Compare done. i--, j-- (now at index 2)</span></div>
<div class="wstep"><span class="wstep-n">Step 2</span><div>
  <div class="arow"><span class="abk">[</span><span class="ac aL">a<span class="pl pL">i</span></span><span class="ac">b<span class="pl">&nbsp;</span></span><span class="ac">#<span class="pl">&nbsp;</span></span><span class="ac">c<span class="pl">&nbsp;</span></span><span class="abk">]</span></div>
  <div class="arow" style="margin-top:5px"><span class="abk">[</span><span class="ac aR">a<span class="pl pR">j</span></span><span class="ac">d<span class="pl">&nbsp;</span></span><span class="ac">#<span class="pl">&nbsp;</span></span><span class="ac">c<span class="pl">&nbsp;</span></span><span class="abk">]</span></div>
</div><span class="wstep-act">s[i]='#' &rarr; skipS=1, i--. t[j]='#' &rarr; skipT=1, j-- (both at index 1)</span></div>
<div class="wstep"><span class="wstep-n">Step 3</span><div></div><span class="wstep-act">s[i]='b', skipS=1 &rarr; discard 'b', skipS=0, i-- (now at index 0).
t[j]='d', skipT=1 &rarr; discard 'd', skipT=0, j-- (now at index 0).</span></div>
<div class="wstep"><span class="wstep-n">Step 4</span><div>
  <div class="arow"><span class="abk">[</span><span class="ac aL">a<span class="pl pL">i</span></span><span class="ac">b<span class="pl">&nbsp;</span></span><span class="ac">#<span class="pl">&nbsp;</span></span><span class="ac">c<span class="pl">&nbsp;</span></span><span class="abk">]</span></div>
  <div class="arow" style="margin-top:5px"><span class="abk">[</span><span class="ac aR">a<span class="pl pR">j</span></span><span class="ac">d<span class="pl">&nbsp;</span></span><span class="ac">#<span class="pl">&nbsp;</span></span><span class="ac">c<span class="pl">&nbsp;</span></span><span class="abk">]</span></div>
</div><span class="wstep-act">s[i]='a', skip=0 &rarr; valid. t[j]='a', skip=0 &rarr; valid. 'a'=='a' &rarr; match! i--, j--. Both exhausted &rarr; return true</span></div>
</div>"""
),

# ── P16 ──────────────────────────────────────────────────────
dict(
num="P16", filename="P16_IsSubsequence",
title="Is Subsequence",
lc=392, diff="Easy", dtype="Same Direction",
problem="""
<p>Given strings <code>s</code> and <code>t</code>, return <code>true</code> if <code>s</code> is a subsequence of <code>t</code> (characters of <code>s</code> appear in <code>t</code> in order, not necessarily contiguously).</p>
<p><strong>Example:</strong> <code>s="ace", t="abcde"</code> &rarr; <code>true</code></p>
""",
layman="""
<p>Use one finger on <code>s</code> and one on <code>t</code>. Walk the <code>t</code> finger forward one character at a time. Whenever the <code>t</code> character matches the <code>s</code> finger's character, advance the <code>s</code> finger too. If <code>s</code>'s finger reaches the end, all characters were found in order → true.</p>
""",
aha="Same-direction two-pointer on two different arrays: i scans s, j scans t. i only advances on a match.",
visual="""s = "ace",  t = "abcde"
      i=0(a)   j=0(a) → match! i++, j++
      i=1(c)   j=1(b) → no match, j++
      i=1(c)   j=2(c) → match! i++, j++
      i=2(e)   j=3(d) → no match, j++
      i=2(e)   j=4(e) → match! i++
      i=3 == s.length() → return true ✓""",
algo=[
    "Set <code>i=0</code> (pointer into s), <code>j=0</code> (pointer into t).",
    "While <code>i &lt; s.length()</code> and <code>j &lt; t.length()</code>: if characters match, <code>i++</code>. Always <code>j++</code>.",
    "Return <code>i == s.length()</code> (all of s was matched).",
],
java="""public boolean isSubsequence(String s, String t) {
    int i = 0, j = 0;
    while (i &lt; s.length() &amp;&amp; j &lt; t.length()) {
        if (s.charAt(i) == t.charAt(j)) i++;
        j++;
    }
    return i == s.length();
}""",
time="O(n) where n=t.length()", space="O(1)",
pattern="Same-direction two-pointer across two strings. i is the 'match tracker', j is the 'scanner'. This is arguably the simplest possible two-pointer problem.",
key="j always advances; i only advances on a match. Done when i reaches end of s.",
walk_html="""<div class="walk">
<div class="walk-title">Trace — green=i (s-pointer) &nbsp;|&nbsp; orange=j (t-scanner) &nbsp;|&nbsp; s="ace", t="abcde"</div>
<div class="wstep"><span class="wstep-n">Start</span><div>
  <div style="font-size:.74rem;color:#64748b;font-family:monospace;margin-bottom:3px">s (match pointer i):</div>
  <div class="arow"><span class="abk">[</span><span class="ac aS">a<span class="pl pS">i</span></span><span class="ac">c<span class="pl">&nbsp;</span></span><span class="ac">e<span class="pl">&nbsp;</span></span><span class="abk">]</span></div>
  <div style="font-size:.74rem;color:#64748b;font-family:monospace;margin-top:5px;margin-bottom:3px">t (scanner j):</div>
  <div class="arow"><span class="abk">[</span><span class="ac aF">a<span class="pl pF">j</span></span><span class="ac">b<span class="pl">&nbsp;</span></span><span class="ac">c<span class="pl">&nbsp;</span></span><span class="ac">d<span class="pl">&nbsp;</span></span><span class="ac">e<span class="pl">&nbsp;</span></span><span class="abk">]</span></div>
</div><span class="wstep-act">i=0 ('a'), j=0 ('a')</span></div>
<div class="wstep"><span class="wstep-n">Step 1</span><div>
  <div class="arow"><span class="abk">[</span><span class="ac">a<span class="pl">&nbsp;</span></span><span class="ac aS">c<span class="pl pS">i</span></span><span class="ac">e<span class="pl">&nbsp;</span></span><span class="abk">]</span></div>
  <div class="arow" style="margin-top:5px"><span class="abk">[</span><span class="ac">a<span class="pl">&nbsp;</span></span><span class="ac aF">b<span class="pl pF">j</span></span><span class="ac">c<span class="pl">&nbsp;</span></span><span class="ac">d<span class="pl">&nbsp;</span></span><span class="ac">e<span class="pl">&nbsp;</span></span><span class="abk">]</span></div>
</div><span class="wstep-act">s[i]='a' == t[j]='a' &rarr; MATCH! i++. Always j++.</span></div>
<div class="wstep"><span class="wstep-n">Step 2</span><div>
  <div class="arow"><span class="abk">[</span><span class="ac">a<span class="pl">&nbsp;</span></span><span class="ac aS">c<span class="pl pS">i</span></span><span class="ac">e<span class="pl">&nbsp;</span></span><span class="abk">]</span></div>
  <div class="arow" style="margin-top:5px"><span class="abk">[</span><span class="ac">a<span class="pl">&nbsp;</span></span><span class="ac">b<span class="pl">&nbsp;</span></span><span class="ac aF">c<span class="pl pF">j</span></span><span class="ac">d<span class="pl">&nbsp;</span></span><span class="ac">e<span class="pl">&nbsp;</span></span><span class="abk">]</span></div>
</div><span class="wstep-act">s[i]='c' &ne; t[j]='b' &rarr; no match. j++ only.</span></div>
<div class="wstep"><span class="wstep-n">Step 3</span><div>
  <div class="arow"><span class="abk">[</span><span class="ac">a<span class="pl">&nbsp;</span></span><span class="ac">c<span class="pl">&nbsp;</span></span><span class="ac aS">e<span class="pl pS">i</span></span><span class="abk">]</span></div>
  <div class="arow" style="margin-top:5px"><span class="abk">[</span><span class="ac">a<span class="pl">&nbsp;</span></span><span class="ac">b<span class="pl">&nbsp;</span></span><span class="ac">c<span class="pl">&nbsp;</span></span><span class="ac aF">d<span class="pl pF">j</span></span><span class="ac">e<span class="pl">&nbsp;</span></span><span class="abk">]</span></div>
</div><span class="wstep-act">s[i]='c' == t[j]='c' &rarr; MATCH! i++. j++. (s[i]='e', t[j]='d' &rarr; no match, j++)</span></div>
<div class="wstep"><span class="wstep-n">Done</span><div>
  <div class="arow" style="margin-top:5px"><span class="abk">[</span><span class="ac">a<span class="pl">&nbsp;</span></span><span class="ac">b<span class="pl">&nbsp;</span></span><span class="ac">c<span class="pl">&nbsp;</span></span><span class="ac">d<span class="pl">&nbsp;</span></span><span class="ac aF">e<span class="pl pF">j</span></span><span class="abk">]</span></div>
</div><span class="wstep-act">s[i]='e' == t[j]='e' &rarr; MATCH! i=3 == s.length() &rarr; return true</span></div>
</div>"""
),

# ── P17 ──────────────────────────────────────────────────────
dict(
num="P17", filename="P17_RemoveElement",
title="Remove Element",
lc=27, diff="Easy", dtype="Slow + Fast",
problem="""
<p>Given an array <code>nums</code> and integer <code>val</code>, remove all occurrences of <code>val</code> in-place. Return the count of remaining elements. Order of remaining elements doesn't matter.</p>
<p><strong>Example:</strong> <code>[3,2,2,3], val=3</code> &rarr; return <code>2</code>, array = <code>[2,2,_,_]</code></p>
""",
layman="""
<p>Identical to Remove Duplicates structure: slow is the write head, fast scans. The difference: instead of skipping repeated values, you skip any value equal to <code>val</code>. Write everything else to slow's position.</p>
""",
aha="Slow+Fast: copy non-val elements to front. The only difference from Move Zeroes is the rejection criterion (==val instead of ==0).",
visual="""[3, 2, 2, 3],  val=3
 S  F              nums[F]=3==val → skip (F++ only)
 S     F           nums[F]=2!=val → nums[S]=2, S++, F++
    S     F        nums[F]=2!=val → nums[S]=2, S++, F++
       S     F     nums[F]=3==val → skip (F++ only)
F exhausted → return S=2 ✓""",
algo=[
    "Set <code>slow=0</code>.",
    "Loop <code>fast</code> from 0 to <code>n-1</code>: if <code>nums[fast] != val</code>, write <code>nums[slow++] = nums[fast]</code>.",
    "Return <code>slow</code>.",
],
java="""public int removeElement(int[] nums, int val) {
    int slow = 0;
    for (int fast = 0; fast &lt; nums.length; fast++) {
        if (nums[fast] != val) nums[slow++] = nums[fast];
    }
    return slow;
}""",
time="O(n)", space="O(1)",
pattern="Slow+Fast: the template is identical for Remove Duplicates, Move Zeroes, Remove Element. Only the filter condition changes.",
key="Three in-place remove problems (P05, P07, P17) use the same 3-line slow/fast pattern. Memorize the template once.",
walk_html="""<div class="walk">
<div class="walk-title">Trace — green=S (write head) &nbsp;|&nbsp; orange=F (scanner) &nbsp;|&nbsp; array=[3,2,2,3], val=3</div>
<div class="wstep"><span class="wstep-n">Start</span><div><div class="arow"><span class="abk">[</span><span class="ac aS aF">3<span class="pl pS">S/F</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">S=0, F=0. val=3 (the value to remove)</span></div>
<div class="wstep"><span class="wstep-n">Step 1</span><div><div class="arow"><span class="abk">[</span><span class="ac aS">3<span class="pl pS">S</span></span><span class="ac aF">2<span class="pl pF">F</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">nums[F]=3 == val &rarr; skip. F++ only (S stays at 0)</span></div>
<div class="wstep"><span class="wstep-n">Step 2</span><div><div class="arow"><span class="abk">[</span><span class="ac aS">2<span class="pl pS">S</span></span><span class="ac aF">2<span class="pl pF">F</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">nums[F]=2 &ne; val &rarr; write nums[S]=2, S++, F++</span></div>
<div class="wstep"><span class="wstep-n">Step 3</span><div><div class="arow"><span class="abk">[</span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac aS">2<span class="pl pS">S</span></span><span class="ac aF">2<span class="pl pF">F</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">nums[F]=2 &ne; val &rarr; write nums[S]=2, S++, F++</span></div>
<div class="wstep"><span class="wstep-n">Step 4</span><div><div class="arow"><span class="abk">[</span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac aS">2<span class="pl pS">S</span></span><span class="ac aF">3<span class="pl pF">F</span></span><span class="abk">]</span></div></div><span class="wstep-act">nums[F]=3 == val &rarr; skip. F++ only</span></div>
<div class="wstep"><span class="wstep-n">Done</span><div><div class="arow"><span class="abk">[</span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac aS">_<span class="pl pS">S</span></span><span class="ac">_<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">F exhausted. Return S=2. First 2 elements are [2,2] — the non-val elements.</span></div>
</div>"""
),

# ── P18 ──────────────────────────────────────────────────────
dict(
num="P18", filename="P18_FindKClosestElements",
title="Find K Closest Elements",
lc=658, diff="Medium", dtype="Opposite Ends (Shrink Window)",
problem="""
<p>Given a sorted array <code>arr</code>, integer <code>k</code>, and integer <code>x</code>, return the <code>k</code> closest integers to <code>x</code> as a sorted list. Ties broken by smaller element.</p>
<p><strong>Example:</strong> <code>arr=[1,2,3,4,5], k=4, x=3</code> &rarr; <code>[1,2,3,4]</code></p>
""",
layman="""
<p>Start with both endpoints of the array. You need to shrink the window down to exactly <code>k</code> elements. Each step, remove the element that's farther from <code>x</code>. If the left element is farther, remove left (<code>left++</code>). If right is farther, remove right (<code>right--</code>). Stop when only k elements remain.</p>
""",
aha="Instead of expanding, you're shrinking a window. Two pointers start at the ends and converge until exactly k elements remain. Compare distances to x to decide which end to remove.",
visual="""arr=[1,2,3,4,5], k=4, x=3

left=0, right=4:  |1-3|=2 vs |5-3|=2 tie → prefer left stays (remove right)
                   right-- → window=[1,2,3,4]

left=0, right=3:  window size = 4 = k → DONE
Result: [1,2,3,4] ✓

(Tie rule: x-arr[mid] &gt; arr[mid+k]-x means right window is closer, so left++.)""",
algo=[
    "Set <code>left=0</code>, <code>right=arr.length-k</code> (binary-search style).",
    "While <code>left &lt; right</code>: compute <code>mid=(left+right)/2</code>.",
    "If <code>x - arr[mid] &gt; arr[mid+k] - x</code>: <code>left=mid+1</code>. Else: <code>right=mid</code>.",
    "Return <code>arr[left..left+k-1]</code>.",
],
java="""public List&lt;Integer&gt; findClosestElements(int[] arr, int k, int x) {
    int left = 0, right = arr.length - k;
    while (left &lt; right) {
        int mid = (left + right) / 2;
        // compare left-window-start vs right-window-end distance to x
        if (x - arr[mid] &gt; arr[mid + k] - x) left = mid + 1;
        else                                    right = mid;
    }
    List&lt;Integer&gt; res = new ArrayList&lt;&gt;();
    for (int i = left; i &lt; left + k; i++) res.add(arr[i]);
    return res;
}""",
time="O(log(n-k) + k)", space="O(1)",
pattern="Shrinking window via binary search on the window's left boundary. Different from simple converging two-pointer — right is bounded by arr.length-k to ensure k elements always fit.",
key="Binary search on the starting index of the k-element window. Compare the two ends' distance to x to decide which way to slide.",
walk_html="""<div class="walk">
<div class="walk-title">Trace — binary search on window start &nbsp;|&nbsp; arr=[1,2,3,4,5], k=4, x=3</div>
<div class="wstep"><span class="wstep-n">Setup</span><div><div class="arow"><span class="abk">[</span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac">4<span class="pl">&nbsp;</span></span><span class="ac">5<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">left=0, right=arr.length-k=1. Binary search: which window start gives k=4 closest elements to x=3?</span></div>
<div class="wstep"><span class="wstep-n">mid=0</span><div>
  <div style="font-size:.74rem;color:#64748b;font-family:monospace;margin-bottom:3px">window starting at 0: [1,2,3,4]</div>
  <div class="arow"><span class="abk">[</span><span class="ac aL">1<span class="pl pL">mid</span></span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac">4<span class="pl">&nbsp;</span></span><span class="ac">5<span class="pl">&nbsp;</span></span><span class="abk">]</span></div>
  <div style="font-size:.74rem;color:#64748b;font-family:monospace;margin-top:5px;margin-bottom:3px">window starting at 1: [2,3,4,5]</div>
  <div class="arow"><span class="abk">[</span><span class="ac">1<span class="pl">&nbsp;</span></span><span class="ac aR">2<span class="pl pR">mid+k</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac">4<span class="pl">&nbsp;</span></span><span class="ac">5<span class="pl">&nbsp;</span></span><span class="abk">]</span></div>
</div><span class="wstep-act">x-arr[0]=3-1=2, arr[0+4]-x=5-3=2. Is 2&gt;2? No &rarr; right=mid=0. Loop ends (left==right).</span></div>
<div class="wstep"><span class="wstep-n">Done</span><div><div class="arow"><span class="abk">[</span><span class="ac aW">1<span class="pl">&nbsp;</span></span><span class="ac aW">2<span class="pl">&nbsp;</span></span><span class="ac aW">3<span class="pl">&nbsp;</span></span><span class="ac aW">4<span class="pl">&nbsp;</span></span><span class="ac">5<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">Window start=0. Return arr[0..3] = [1,2,3,4]. (Tie prefers smaller element &rarr; left window wins)</span></div>
</div>"""
),

# ── P19 ──────────────────────────────────────────────────────
dict(
num="P19", filename="P19_ShortestUnsortedSubarray",
title="Shortest Unsorted Continuous Subarray",
lc=581, diff="Medium", dtype="Opposite Ends",
problem="""
<p>Given an integer array <code>nums</code>, find the length of the <strong>shortest subarray</strong> that, if sorted, makes the whole array sorted.</p>
<p><strong>Example:</strong> <code>[2,6,4,8,10,9,15]</code> &rarr; <code>5</code> (sort [6,4,8,10,9] → entire array sorted)</p>
""",
layman="""
<p>Find where the array 'breaks' from the left and from the right. From the left, scan with a running max — whenever a number is smaller than the running max, it's out of place (mark as the right boundary). From the right, scan with a running min — whenever a number is larger than the running min, it's out of place (mark as the left boundary). The distance between these two boundaries is the answer.</p>
""",
aha="Two passes (or conceptually two pointers) from opposite ends using a running max/min. The 'broken' region is defined by the last position that violated the sorted order from each side.",
visual="""[2, 6, 4, 8, 10,  9, 15]
 →  running max: 2,6,6,8,10,10,15
    nums[i]&lt;runMax?  N,N,Y(4&lt;6),N,N, Y(9&lt;10),N
    rightBound = last Y = index 5

 ←  running min: 15,9,9,8,8,4,2
    nums[i]&gt;runMin?  N,N,N,N, Y(10&gt;9), N, N
    leftBound = last Y (from right) = index 1

Answer: 5 - 1 + 1 = 5 ✓""",
algo=[
    "Scan left→right with <code>maxSoFar</code>; update <code>right</code> boundary whenever <code>nums[i] &lt; maxSoFar</code>.",
    "Scan right→left with <code>minSoFar</code>; update <code>left</code> boundary whenever <code>nums[i] &gt; minSoFar</code>.",
    "Return <code>right - left + 1</code> (initialize <code>right=-2, left=-1</code> so if already sorted, result = 0).",
],
java="""public int findUnsortedSubarray(int[] nums) {
    int n = nums.length;
    int left = -1, right = -2;          // -2 so right-left+1 = 0 if sorted
    int maxSoFar = nums[0], minSoFar = nums[n-1];
    for (int i = 1; i &lt; n; i++) {
        maxSoFar = Math.max(maxSoFar, nums[i]);
        if (nums[i] &lt; maxSoFar) right = i;
    }
    for (int i = n-2; i &gt;= 0; i--) {
        minSoFar = Math.min(minSoFar, nums[i]);
        if (nums[i] &gt; minSoFar) left = i;
    }
    return right - left + 1;
}""",
time="O(n)", space="O(1)",
pattern="Two independent linear scans (forward and backward) that together define the 'broken' region. Each scan mimics one of the two pointers doing their own job independently.",
key="Initialize right=-2 so right-left+1=0 handles the already-sorted edge case elegantly.",
walk_html="""<div class="walk">
<div class="walk-title">Two-pass scan &nbsp;|&nbsp; array=[2,6,4,8,10,9,15] &nbsp;|&nbsp; forward finds rightBound, backward finds leftBound</div>
<div class="wstep"><span class="wstep-n">Forward</span><div><div class="arow"><span class="abk">[</span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">6<span class="pl">&nbsp;</span></span><span class="ac aF">4<span class="pl pF">!</span></span><span class="ac">8<span class="pl">&nbsp;</span></span><span class="ac">10<span class="pl">&nbsp;</span></span><span class="ac aF">9<span class="pl pF">!</span></span><span class="ac">15<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">runMax: 2,6,6,8,10,10,15. Violation (nums[i]&lt;runMax) at i=2 (4&lt;6) and i=5 (9&lt;10). rightBound=5</span></div>
<div class="wstep"><span class="wstep-n">Backward</span><div><div class="arow"><span class="abk">[</span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac aS">6<span class="pl pS">!</span></span><span class="ac">4<span class="pl">&nbsp;</span></span><span class="ac">8<span class="pl">&nbsp;</span></span><span class="ac aS">10<span class="pl pS">!</span></span><span class="ac">9<span class="pl">&nbsp;</span></span><span class="ac">15<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">runMin: 15,9,9,8,8,4,2. Violation (nums[i]&gt;runMin) at i=4 (10&gt;9) and i=1 (6&gt;4). leftBound=1</span></div>
<div class="wstep"><span class="wstep-n">Answer</span><div><div class="arow"><span class="abk">[</span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac aL">6<span class="pl pL">left</span></span><span class="ac">4<span class="pl">&nbsp;</span></span><span class="ac">8<span class="pl">&nbsp;</span></span><span class="ac">10<span class="pl">&nbsp;</span></span><span class="ac aR">9<span class="pl pR">right</span></span><span class="ac">15<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">rightBound-leftBound+1 = 5-1+1 = 5. Sort [6,4,8,10,9] &rarr; entire array sorted!</span></div>
</div>"""
),

# ── P20 ──────────────────────────────────────────────────────
dict(
num="P20", filename="P20_MinimizeMaxPairSum",
title="Minimize Maximum Pair Sum in Array",
lc=1877, diff="Medium", dtype="Opposite Ends",
problem="""
<p>The <em>pair sum</em> of two elements is their sum. Given <code>nums</code> with even length, pair all elements into <code>n/2</code> pairs (each element in exactly one pair). Minimize the <strong>maximum</strong> pair sum. Return that minimum possible maximum.</p>
<p><strong>Example:</strong> <code>[3,5,2,3]</code> &rarr; <code>7</code> (pairs: (2,5) and (3,3))</p>
""",
layman="""
<p>Sort the array. Pair the smallest with the largest, the second-smallest with the second-largest, and so on. This balances all pairs — no pair gets two extreme values. The maximum pair sum of this balanced pairing is provably the minimum possible maximum. It's the same greedy insight as Boats to Save People.</p>
""",
aha="Sort + pair smallest with largest. This greedy minimizes the max pair sum — pairing any other way can only make it worse.",
visual="""[3, 5, 2, 3]   sorted: [2, 3, 3, 5]

Pair: (2,5)→sum=7   (3,3)→sum=6    maxSum = 7

Any other pairing: (2,3)+(3,5) → maxSum=8 (worse)
                   (2,3)+(5,3) → maxSum=8 (worse)

Return 7 ✓""",
algo=[
    "Sort <code>nums</code>.",
    "Set <code>left=0</code>, <code>right=n-1</code>, <code>maxSum=0</code>.",
    "While <code>left &lt; right</code>: <code>maxSum = max(maxSum, nums[left]+nums[right])</code>, then <code>left++</code>, <code>right--</code>.",
    "Return <code>maxSum</code>.",
],
java="""public int minPairSum(int[] nums) {
    Arrays.sort(nums);
    int left = 0, right = nums.length - 1, maxSum = 0;
    while (left &lt; right) {
        maxSum = Math.max(maxSum, nums[left] + nums[right]);
        left++; right--;
    }
    return maxSum;
}""",
time="O(n log n)", space="O(1)",
pattern="Same sort + opposite-end two-pointer as Boats to Save People. Greedy pairing of extremes minimizes imbalance.",
key="Sort, then pair ends together. This is the 3-line core of many greedy problems: sort → pair extremes → track aggregate.",
walk_html="""<div class="walk">
<div class="walk-title">Trace — blue=L (smallest) &nbsp;|&nbsp; red=R (largest) &nbsp;|&nbsp; [3,5,2,3] sorted: [2,3,3,5]</div>
<div class="wstep"><span class="wstep-n">Sort</span><div><div class="arow"><span class="abk">[</span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac">5<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">Sort first. maxSum=0. Pair smallest with largest to balance all pairs.</span></div>
<div class="wstep"><span class="wstep-n">Step 1</span><div><div class="arow"><span class="abk">[</span><span class="ac aL">2<span class="pl pL">L</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac">3<span class="pl">&nbsp;</span></span><span class="ac aR">5<span class="pl pR">R</span></span><span class="abk">]</span></div></div><span class="wstep-act">pair (2,5): sum=7. maxSum=7. L++, R--</span></div>
<div class="wstep"><span class="wstep-n">Step 2</span><div><div class="arow"><span class="abk">[</span><span class="ac">2<span class="pl">&nbsp;</span></span><span class="ac aL">3<span class="pl pL">L</span></span><span class="ac aR">3<span class="pl pR">R</span></span><span class="ac">5<span class="pl">&nbsp;</span></span><span class="abk">]</span></div></div><span class="wstep-act">pair (3,3): sum=6. maxSum stays 7. L++, R--. L&ge;R, done.</span></div>
<div class="wstep"><span class="wstep-n">Done</span><div style="color:#6ee7b7;font-family:monospace;font-size:.82rem;padding:8px 0">Return 7</div><span class="wstep-act">Any other pairing: (2,3)+(3,5) &rarr; max=8 (worse). Pairing extremes is optimal!</span></div>
</div>"""
),

]  # end PROBLEMS list


# ──────────────────────────────────────────────────────────────
#  Generate one HTML file per problem
# ──────────────────────────────────────────────────────────────
def generate_problem_html(p):
    diff_badge = f'<span class="badge {p["diff"].lower()}">{p["diff"]}</span>'
    body = f"""
<header>
  <div class="meta">Arrays &rsaquo; Two Pointer &rsaquo; {p['dtype']}</div>
  <h1>{p['num']} &mdash; {p['title']}</h1>
  <div class="meta">
    {diff_badge}
    &nbsp;&bull;&nbsp; LeetCode #{p['lc']}
    &nbsp;&bull;&nbsp; Pattern: <strong>{p['dtype']}</strong>
  </div>
</header>

<div class="section blue">
<h2>&#128221; The Problem</h2>
{p['problem']}
</div>

<div class="section green">
<h2>&#127775; In Layman's Terms</h2>
{p['layman']}
</div>

<div class="section orange">
<h2>&#9889; The Aha Moment</h2>
<p>{p['aha']}</p>
</div>

<div class="section blue">
<h2>&#128250; Visual Walkthrough</h2>
{p.get('walk_html', f'<div class="diagram">{p["visual"]}</div>')}
</div>

<div class="section green">
<h2>&#128295; Algorithm (Step by Step)</h2>
{steps(p['algo'])}
</div>

<div class="section purple">
<h2>&#9749; Java Solution</h2>
{code(p['java'])}
</div>

<div class="section">
<h2>&#9203; Complexity</h2>
{kv([("Time", p['time']), ("Space", p['space'])])}
</div>

<div class="section orange">
<h2>&#128200; Two Pointer Pattern</h2>
{pattern_box(p['pattern'])}
</div>

{insight(p['key'])}
"""
    return make_page(f"{p['num']} – {p['title']}", body)


# ──────────────────────────────────────────────────────────────
#  MAIN
# ──────────────────────────────────────────────────────────────
if __name__ == "__main__":
    out_dir = os.path.dirname(os.path.abspath(__file__))

    # Master overview
    master_html = generate_master()
    master_path = os.path.join(out_dir, "00_Masterclass.html")
    with open(master_path, "w", encoding="utf-8") as f:
        f.write(master_html)
    print(f"Generated: 00_Masterclass.html")

    # Individual problem guides
    for p in PROBLEMS:
        html = generate_problem_html(p)
        path = os.path.join(out_dir, f"{p['filename']}.html")
        with open(path, "w", encoding="utf-8") as f:
            f.write(html)
        print(f"Generated: {p['filename']}.html")

    print(f"\nDone! {len(PROBLEMS) + 1} HTML study guides generated in: {out_dir}")
    print("Open any .html file in your browser -> Ctrl+P -> Save as PDF")
