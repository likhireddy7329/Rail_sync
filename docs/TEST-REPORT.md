# RailSync test report

Command executed from the project root:

```bash
javac -Xlint:all -d out src/*.java tests/*.java
java -cp out AlgorithmSmokeTest
```

Output:

```text
PASS: 22 algorithm checks succeeded.
```

Coverage includes KMP, Rabin–Karp, Z-function, Aho–Corasick, edit distance, suffix array, suffix automaton, matrix-chain DP, optimal BST, Edmonds–Karp, Dinic, bipartite matching, SAT examples, 3-SAT-to-CLIQUE construction, Miller–Rabin, parallel scan/reduce, and Brent-style estimate. These are deterministic smoke tests, not exhaustive proofs or production qualification.
