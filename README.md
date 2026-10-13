# RailSync — Intelligent Railway Operations Platform

A Java console-only railway operations simulator demonstrating all six DSA course outcomes in practical railway workflows. It uses fictional training records and local CSV files. It is **not connected to live railway data, ticketing services, signalling, or safety-critical control systems**.

## Requirements
- JDK 17 or newer
- VS Code with Extension Pack for Java recommended
- No Maven, Gradle, database, or third-party libraries required

## Run in VS Code
1. Extract `RailSync.zip`.
2. Open the extracted `RailSync` folder in VS Code.
3. Open **Terminal → New Terminal** in the project root (the folder containing `src`, `data`, and `README.md`).
4. Run:

**Windows PowerShell**
```powershell
.\run.bat
```
If needed, run manually:
```powershell
javac -d out src\*.java
java -cp out Main
```

**Linux/macOS**
```bash
chmod +x run.sh
./run.sh
```

## Run tests

**Windows PowerShell**
```powershell
.\test.bat
```
Or manually:
```powershell
javac -d out src\*.java tests\*.java
java -cp out AlgorithmSmokeTest
```

**Linux/macOS**
```bash
javac -d out src/*.java tests/*.java
java -cp out AlgorithmSmokeTest
```

The included smoke suite checks 22 core algorithm cases.

## Features
- Train service records: list, add, status update, search, capacity validation.
- Timetable and platform allocation: list/add schedules, reject exact platform/time collisions, inspect conflict graph.
- Passenger tickets: create demonstration tickets and search by PNR, passenger, or train.
- Route network: Edmonds–Karp and Dinic max-flow comparisons plus train/platform bipartite matching.
- Maintenance: report/list/close incidents.
- Event monitoring: Aho–Corasick keyword scans and reservoir sampling.
- Operations reports: train, schedule, ticket, passenger, capacity, delay, maintenance, incident, and event totals.
- DSA lab with modules for CO1–CO6.

## CSV persistence

Local files in `data/`: `trains.csv`, `schedules.csv`, `tickets.csv`, `incidents.csv`, and `events.csv`. Choose **Save all CSV data** or **Save & exit** to persist updates. The CSV writer quotes values and escapes embedded quotes. Keep the terminal working directory at the project root. All supplied data is synthetic.

## DSA mapping

| CO | Algorithms | Railway workflow |
|---|---|---|
| CO1 | KMP, Z-function, Rabin–Karp, Aho–Corasick | Search records and scan alerts |
| CO2 | Prefix-doubling suffix array, Kasai LCP, suffix automaton | Analyze route/event strings and repeated substrings |
| CO3 | Levenshtein, Damerau–Levenshtein, bitmask route DP, matrix-chain DP, optimal BST | Station-name correction and small planning examples |
| CO4 | Edmonds–Karp, Dinic, bipartite matching | Illustrative network flow and platform matching |
| CO5 | Small-instance SAT, 3-SAT-to-CLIQUE graph construction, graph complement, independent-set/vertex-cover relation, vertex-cover 2-approximation | Timetable conflict decision support |
| CO6 | Randomized QuickSort, reservoir sampling, Miller–Rabin, parallel scan/reduce, Brent-style work estimate | Event sampling and passenger-batch processing |

## Project structure
```text
RailSync/
├── src/Main.java
├── src/RailwayStore.java
├── src/Algorithms.java
├── tests/AlgorithmSmokeTest.java
├── data/*.csv
├── docs/DSA-MAPPING.md
├── docs/TEST-REPORT.md
├── run.bat  run.sh  test.bat
└── README.md
```

## Honest scope notes
This is an educational simulator, not a production railway system. CO2 uses **prefix-doubling** suffix-array construction, not SA-IS induced sorting; suffix-automaton analysis is included, but a separate compressed suffix tree is not. The SAT solver brute-forces small instances. The parallel scan/reduce is a simple Java worker-chunk implementation, not a GPU/Blelloch implementation. Capacities and service records are illustrative, and outputs must not be used for real railway or safety decisions.
