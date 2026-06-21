# DSA Practice — RisingBrain Sheet

A self-study system for mastering Data Structures and Algorithms in Java by following the [RisingBrain pattern-wise sheet](https://www.risingbrain.org/sheet). Every topic is broken into 20 hand-picked problems, every problem ships with a Java practice stub and an HTML study guide, and every sub-topic has a "Masterclass" page that teaches the pattern from scratch.

## What this project is

The internet is full of LeetCode lists, but they don't teach you how to *think*. This project takes the RisingBrain sheet (which organizes problems by **pattern**, not by topic or difficulty) and adds:

1. **A Java stub for every problem** — so you write the solution yourself rather than copying it.
2. **A printable HTML study guide for every problem** — read it *after* you've attempted the problem. It shows the pattern, the Java solution, and the key insight that unlocks the problem.
3. **A "Masterclass" HTML for every sub-topic** — read it *first*. It introduces the jargon, gives you the code template, and lists all 20 problems in suggested order (Easy → Medium → Hard).
4. **A global index** at `src/00_Index.html` that ties everything together and shows the recommended stage order.

The whole thing is designed to be consumed in one of two ways: **(a)** open the HTMLs in a browser and read them like a textbook, or **(b)** print them as PDFs (Ctrl+P → Save as PDF) to study offline.

## Why pattern-wise (and why 20 per pattern)

Most people grind LeetCode randomly and never internalize *why* a problem belongs to a family. The RisingBrain approach is: pick one pattern, do 20 problems on that pattern, and the pattern becomes muscle memory. After 20 reps you stop "trying to think of a clever idea" and start *recognizing* the problem on sight.

Twenty problems is the number where:
- All the variations have appeared (forward, reverse, with constraints, with twists)
- You've seen the standard implementation 5+ times
- You've debugged your own off-by-one mistakes
- You can write the template from memory

That's mastery. One topic at a time.

## Folder structure

```
src/
  00_Index.html          ← global hub — start here
  util/
    Test.java            ← shared test helper used by every stub
  arrays/                ← Stage 1
    twopointer/          ← P01–P20 + 00_Masterclass.html + 20 guides
    slidingwindow/
    prefixsum/
    kadane/
  strings/               ← Stage 2
    twopointer/
    slidingwindow/
  binarysearch/          ← Stage 3
    classic/
    lowerupperbound/
    in2dmatrix/
    onanswers/
  hashmap/               ← Stage 4
    frequency/
  recursion/             ← Stage 5
    divideconquer/
  backtracking/          ← Stage 5
    choice/
    decision/
    constraint/
    grid/
  tree/                  ← Stage 6
    bfs/
    dfs/
    lca/
    serialization/
  heap/                  ← Stage 7
    topk/
  trie/                  ← Stage 7
    basic/
    wordbreak/
    bitwise/
  graphs/                ← Stage 8
    bfs/
    dfs/
    topological/
    shortestpath/
    unionfind/
  dp/                    ← Stage 8
    linear/
    grid/
    intervals/
    knapsack/
```

Every leaf folder contains exactly 41 files:
- 20 × `P##_ProblemName.java` — practice stubs
- 20 × `P##_ProblemName.html` — per-problem study guides
- 1 × `00_Masterclass.html` — the pattern overview

## Anatomy of a Java stub

Every `.java` file looks the same:

```java
package <topic>.<subtopic>;
import util.Test;
/**
 * <Problem Name>
 * Topic    : <Topic Name>
 * Pattern  : <pattern hint — what category this problem belongs to>
 * Difficulty: Easy | Medium | Hard
 * Source   : LC #<number>  (or "Classic" for non-LeetCode)
 */
public class P##_Problem_Name {
    public static void main(String[] args) {
        P##_Problem_Name sol = new P##_Problem_Name();
        Test.summary();
    }
}
```

The empty class body is intentional. **You** write the solution.

The `util.Test` helper (in `src/util/Test.java`) gives you `Test.assertEquals(...)`, `Test.assertTrue(...)`, and `Test.summary()` — a tiny zero-dependency test harness so you don't need JUnit. When you implement a method, you write a few `Test.assertEquals(expected, actual)` calls in `main` and run the file directly. The `Test.summary()` at the end prints pass/fail counts.

## Anatomy of a per-problem HTML guide

Every `.html` file is a compact, printable card with three sections:

```
┌────────────────────────────────────────────────┐
│ ← Topic Masterclass                            │
│ Px — Problem Name                              │
│ [Difficulty badge] • LC #<number>              │
│                                                │
│ ┌─ Pattern / Java ───────────────────────────┐│
│ │ // Code snippet showing the canonical      ││
│ │ // template / approach for this problem    ││
│ └────────────────────────────────────────────┘│
│                                                │
│ ┌─ Insight ──────────────────────────────────┐│
│ │ The one sentence that makes the problem    ││
│ │ "click" — usually a non-obvious framing.   ││
│ └────────────────────────────────────────────┘│
└────────────────────────────────────────────────┘
```

Read it AFTER your attempt, not before. The Insight box is the most important part — that's the line you'd write on a flash card.

## Anatomy of a Masterclass

Every `00_Masterclass.html` walks the pattern from zero. The structure is:

1. **Lede** — one paragraph explaining when to reach for this pattern.
2. **Jargon Buster** — definitions for every technical term used in the topic (so you never have to Google "what's an SCC?" mid-problem).
3. **Java Template(s)** — copy-pasteable code skeletons (e.g., Dijkstra's main loop, Kadane's, 0/1 knapsack iteration order).
4. **Problem Index** — a table of all 20 problems, sorted by suggested order, color-coded by difficulty, with direct links to each per-problem guide.

Read the Masterclass before you start a sub-topic. Then bounce back to it whenever you forget the template.

## How to study

### The loop
1. Open `src/00_Index.html` in a browser.
2. Click into the next sub-topic you haven't started.
3. Read its `00_Masterclass.html` end to end. Don't skip the Jargon Buster.
4. Open the first problem's `.java` stub. **Don't open the HTML guide yet.**
5. Try to solve the problem. Spend up to 30 minutes. Write `Test.assertEquals` calls and run.
6. Whether you solved it or not, NOW open the per-problem HTML. Compare your approach to the template. Read the Insight.
7. If you couldn't solve it, mark it for re-attempt in 3 days.
8. Move to the next problem.

### Save guides as PDF
1. Open any `.html` in your browser (right-click → Open With → Browser, or just double-click).
2. Press **Ctrl + P** → choose **Save as PDF**.
3. You now have an offline notebook of every pattern you've studied.

### Run a Java file in VS Code
1. Install the **Extension Pack for Java** (Microsoft).
2. Open any `.java` file.
3. Click the **Run** code-lens that appears above the `main` method.
4. Output appears in the Debug Console; `Test.summary()` prints pass/fail at the end.

## Recommended order

Stages are designed so each one builds on the previous. **Do them in order.**

### Stage 1 — Arrays · Foundational patterns
You learn the four building blocks every other topic reuses.
- [ ] Two Pointer
- [ ] Sliding Window
- [ ] Prefix Sum
- [ ] Kadane's Algorithm

### Stage 2 — Strings · Same patterns, new data
Strings are just `char[]`, so Stage 1's patterns transfer. You only learn the string-specific twists.
- [ ] Strings · Two Pointer
- [ ] Strings · Sliding Window

### Stage 3 — Search
The single most "shows up in interviews" family. The four variants cover ~80% of all binary-search problems you'll ever see.
- [ ] Binary Search · Classic
- [ ] Binary Search · Lower/Upper Bound
- [ ] Binary Search · 2D Matrix
- [ ] Binary Search · On Answers (parametric search)

### Stage 4 — Hashing
A short stage but a high-leverage one — every problem with "duplicate", "frequency", or "count" becomes trivial after this.
- [ ] HashMap · Frequency

### Stage 5 — Recursion & Backtracking
Where most people get stuck. The four backtracking sub-topics teach you the difference between *enumerating choices*, *making decisions*, *pruning with constraints*, and *exploring grids*.
- [ ] Recursion · Divide & Conquer
- [ ] Backtracking · Choice
- [ ] Backtracking · Decision
- [ ] Backtracking · Constraint
- [ ] Backtracking · Grid

### Stage 6 — Trees
Trees are recursion's natural habitat. After Stage 5 these feel like a free win.
- [ ] Tree · BFS
- [ ] Tree · DFS
- [ ] Tree · LCA (Lowest Common Ancestor)
- [ ] Tree · Serialization

### Stage 7 — Heaps & Tries
Two specialized data structures that show up in 1 of every 5 hard problems.
- [ ] Heap · Top K
- [ ] Trie · Basic
- [ ] Trie · Word Break
- [ ] Trie · Bitwise (XOR queries)

### Stage 8 — Graphs & DP
The boss level. By the time you reach here, you've already practiced most graph traversals (Stage 6) and most recursive thinking (Stage 5). Now you formalize them.
- [ ] Graphs · BFS
- [ ] Graphs · DFS
- [ ] Graphs · Topological Sort
- [ ] Graphs · Shortest Path (Dijkstra / Bellman-Ford / Floyd-Warshall / 0-1 BFS)
- [ ] Graphs · Union-Find (DSU)
- [ ] DP · Linear (1-D recurrences)
- [ ] DP · Grid (2-D recurrences, edit-distance-style)
- [ ] DP · Intervals (split DP, minimax, Burst Balloons family)
- [ ] DP · Knapsack (0/1 and unbounded)

Tick each box only after you've **actually solved** the problem with the file open, not just after you've read the guide.

## Files outside `src/`

- `bin/` — compiled `.class` files (auto-generated by your IDE; safe to ignore or delete).
- `add_problem_links.py`, `dedupe_package.py`, `find_duplicates.py`, `fix_java_files.py`, `strip_bom.py` — one-shot maintenance scripts used to bootstrap the project. You won't need to run them unless you're regenerating stubs in bulk.
- `.claude/` — Claude Code project settings.
- `.vscode/` — VS Code workspace settings.

## Roadmap

The hierarchy in `src/00_Index.html` is the canonical list. Stages 1–8 are complete (33 sub-topics × 20 problems = 660 problems). Beyond the indexed stages, partial scaffolding exists for several sibling sub-topics (`linkedlist/*`, `stack/*`, `bst/*`, `bitmanip/*`, `graph/*` (note: separate from the indexed `graphs/*`), `greedy/*`, `dp/{strings,stocks,trees}`, etc.) — they have a handful of stubs each but no study guides yet. Build them out when you've finished the main 33.

## Credits

- Problem selection follows the [RisingBrain DSA sheet](https://www.risingbrain.org/sheet).
- Java stubs, HTML study guides, and the global index were generated with [Claude Code](https://claude.com/claude-code).
