---
layout: default
title: Design
nav_order: 2
description: "Elastiknn Design"
permalink: /design
---

# Design

This document describes Elastiknn's design goals, decisions, and tradeoffs.

## Operational Simplicity

## Seamless Integration in Existing Elasticsearch Workflows

## Mechanical Sympathy

1. Operational simplicity
2. Seamless integration in 


Before examining metrics, here are some of Elastiknn's key characteristics and tradeoffs.

Elastiknn runs entirely in the standard Elasticsearch JVM. This is in contrast to alternative solutions, like the OpenDistro KNN plugin, which manages a C/C++ child process for vector search. 

Elastiknn uses standard, battle-tested Elasticsearch and Lucene constructs. This is in contrast to ongoing work in the Lucene community to add custom storage formats for vectors. The only non-standard construct employed by Elastiknn is well-tested use of the `sun.misc.Unsafe` library for performant vector serialization.

Elastiknn stores all data on disk in standard Lucene segments with no explicit in-memory cache. This, in combination with using standard constructs, means the JVM CPU and memory profiles should not differ significantly from standard text search.

Elastiknn uses Locality-sensitive hashing algorithms for approximate search. If you follow the approximate nearest neighbor search literature, you know that recent breakthroughs have mostly used graph-based algorithms. The reason for choosing hashing algorithms is that hashes are a lot like words in a document: when you hash a vector, you get a list of tokens that can be indexed and search just like a paragraph of text. Elasticsearch and Lucene are optimized for this storage and access pattern, so it's a natural decision to exploit those optimizations.