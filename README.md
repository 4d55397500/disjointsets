disjointsets
---
Efficient implementation in Java of testing whether two sets are disjoint. Merge sort the smaller set in O(n * log n), then check existence with binary search for each member of the other set in O(m * log n).

Total runtime is O((n +m) * log n).
