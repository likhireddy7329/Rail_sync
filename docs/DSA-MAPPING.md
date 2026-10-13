# RailSync DSA mapping and complexity notes

All records and capacities are fictional. The menu exposes algorithm demonstrations through railway workflows where practical.

## CO1 — String algorithms
- **KMP:** phrase search in service/ticket text; `O(n+m)`.
- **Z-function:** prefix-match lengths; `O(n)`.
- **Rabin–Karp:** rolling-hash search for all occurrences; expected `O(n+m)`, with verification after hash matches.
- **Aho–Corasick:** trie/failure-link scan for multiple alert keywords in one text pass plus output cost.

## CO2 — Suffix structures
- **Suffix array:** prefix-doubling with comparison sorting; `O(n log² n)` in this implementation.
- **Kasai LCP:** longest common prefix of adjacent suffixes; `O(n)` after suffix array.
- **Suffix automaton:** distinct non-empty substring count from state lengths and suffix links.
- **Scope caveat:** SA-IS induced sorting and a separate compressed suffix-tree implementation are not included. Do not claim those implementations in a presentation.

## CO3 — Dynamic programming
- **Levenshtein / Damerau–Levenshtein:** station spelling correction; `O(mn)` time.
- **Bitmask route DP:** exact small traveling-salesperson-style route example; `O(n² 2ⁿ)` time and `O(n 2ⁿ)` space.
- **Matrix-chain multiplication:** `O(n³)` time and `O(n²)` space.
- **Optimal BST:** `O(n³)` time and `O(n²)` space in this simple implementation.

## CO4 — Flow and matching
- **Edmonds–Karp:** BFS augmenting paths; `O(VE²)`.
- **Dinic:** level graph/blocking flow; general bound `O(V²E)`.
- **Bipartite matching:** augmenting-path matching demonstration.
- Capacity values are synthetic examples, not station throughput data.

## CO5 — NP-completeness and approximation
- **SAT:** exhaustive assignment search for small instances (`O(2ⁿ × clauses × literals)`).
- **3-SAT → CLIQUE:** one vertex per literal occurrence; connect compatible literals from different clauses. A clique whose size equals the clause count corresponds to a satisfying selection.
- **Complement / independent set / vertex cover:** includes complement graph construction and the complement relation between independent sets and vertex covers.
- **Vertex-cover 2-approximation:** selects both endpoints of each uncovered edge; standard factor-2 approximation.

## CO6 — Randomized and parallel algorithms
- **Randomized QuickSort:** expected `O(n log n)`, worst-case `O(n²)`.
- **Reservoir sampling:** one-pass uniform sample from a stream.
- **Miller–Rabin:** deterministic witness set with `BigInteger` modular arithmetic for signed 64-bit positive inputs.
- **Parallel scan/reduce:** chunks a local integer array among Java worker threads; not a GPU/Blelloch implementation.
- **Brent-style estimate:** illustrates `W/P + O(P)` reasoning, not a measured runtime guarantee.

Algorithms provide educational decision support only; they do not authorize live schedule, ticket, signalling, or maintenance decisions.
