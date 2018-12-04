(ns advent-of-code-2018.dec_fourth
  (:require [clj-time.format :as f]
            [clj-time.coerce :as c]
            [clj-time.core :as t]
            [clj-time.periodic :as p]))


(def real-input "[1518-05-27 00:42] falls asleep
  [1518-07-14 00:53] falls asleep
  [1518-09-22 00:10] falls asleep
  [1518-10-27 00:55] wakes up
  [1518-10-25 00:53] falls asleep
  [1518-06-02 00:56] wakes up
  [1518-07-02 00:05] falls asleep
  [1518-08-04 00:16] falls asleep
  [1518-03-19 00:21] falls asleep
  [1518-05-15 00:53] wakes up
  [1518-06-10 00:46] falls asleep
  [1518-09-01 23:52] Guard #3187 begins shift
  [1518-03-14 00:43] wakes up
  [1518-04-11 00:00] Guard #2207 begins shift
  [1518-08-08 00:48] wakes up
  [1518-03-29 00:29] falls asleep
  [1518-10-03 00:55] wakes up
  [1518-04-23 00:54] wakes up
  [1518-04-18 00:14] falls asleep
  [1518-08-19 00:44] wakes up
  [1518-03-31 00:02] Guard #1901 begins shift
  [1518-10-14 00:59] wakes up
  [1518-05-12 00:30] falls asleep
  [1518-07-08 00:23] falls asleep
  [1518-06-22 00:03] Guard #1499 begins shift
  [1518-04-29 00:03] Guard #191 begins shift
  [1518-06-05 00:35] falls asleep
  [1518-11-08 00:05] wakes up
  [1518-08-29 00:24] falls asleep
  [1518-07-23 00:41] wakes up
  [1518-03-03 00:58] wakes up
  [1518-07-03 00:44] falls asleep
  [1518-09-03 00:04] wakes up
  [1518-06-14 00:18] falls asleep
  [1518-09-15 23:56] Guard #1103 begins shift
  [1518-04-24 23:56] Guard #601 begins shift
  [1518-08-17 00:23] falls asleep
  [1518-02-13 00:40] falls asleep
  [1518-07-20 00:00] Guard #1069 begins shift
  [1518-07-12 00:26] falls asleep
  [1518-02-22 00:58] wakes up
  [1518-11-03 00:24] falls asleep
  [1518-11-20 00:00] Guard #599 begins shift
  [1518-08-12 00:28] falls asleep
  [1518-10-11 00:36] wakes up
  [1518-06-11 00:58] wakes up
  [1518-04-01 00:44] falls asleep
  [1518-07-17 00:41] wakes up
  [1518-10-14 00:53] wakes up
  [1518-07-16 00:02] Guard #1031 begins shift
  [1518-11-09 00:50] wakes up
  [1518-04-19 00:35] falls asleep
  [1518-09-06 00:24] wakes up
  [1518-04-15 00:00] Guard #599 begins shift
  [1518-07-21 00:44] wakes up
  [1518-08-09 00:02] Guard #2477 begins shift
  [1518-11-06 00:32] falls asleep
  [1518-07-31 00:49] wakes up
  [1518-05-06 00:52] wakes up
  [1518-11-21 00:00] Guard #1607 begins shift
  [1518-03-15 00:43] wakes up
  [1518-07-20 00:08] falls asleep
  [1518-10-12 00:55] falls asleep
  [1518-08-30 00:04] falls asleep
  [1518-03-16 00:17] wakes up
  [1518-05-31 00:19] wakes up
  [1518-05-14 23:52] Guard #1789 begins shift
  [1518-10-07 00:13] falls asleep
  [1518-04-24 00:45] wakes up
  [1518-08-14 23:59] Guard #2617 begins shift
  [1518-11-04 00:41] falls asleep
  [1518-04-21 00:57] wakes up
  [1518-08-11 00:00] Guard #2213 begins shift
  [1518-10-28 23:56] Guard #1103 begins shift
  [1518-06-29 00:50] wakes up
  [1518-07-27 00:19] falls asleep
  [1518-06-16 00:39] wakes up
  [1518-05-23 00:42] falls asleep
  [1518-09-08 00:57] falls asleep
  [1518-08-01 00:18] falls asleep
  [1518-09-07 00:16] wakes up
  [1518-04-18 00:41] wakes up
  [1518-08-31 00:50] wakes up
  [1518-09-03 00:58] wakes up
  [1518-04-12 00:48] wakes up
  [1518-04-23 00:19] wakes up
  [1518-03-19 00:26] wakes up
  [1518-04-05 00:05] falls asleep
  [1518-08-19 00:31] falls asleep
  [1518-09-26 00:37] wakes up
  [1518-03-17 00:34] falls asleep
  [1518-10-31 00:46] wakes up
  [1518-06-29 00:57] wakes up
  [1518-02-14 23:49] Guard #1997 begins shift
  [1518-11-13 00:51] wakes up
  [1518-03-10 00:42] wakes up
  [1518-03-15 00:48] falls asleep
  [1518-06-19 00:09] falls asleep
  [1518-05-03 00:03] Guard #2221 begins shift
  [1518-03-10 00:26] falls asleep
  [1518-03-16 00:58] wakes up
  [1518-06-27 00:24] wakes up
  [1518-07-08 23:46] Guard #1069 begins shift
  [1518-10-08 00:48] wakes up
  [1518-07-30 00:00] falls asleep
  [1518-02-28 00:00] Guard #1103 begins shift
  [1518-10-29 23:58] Guard #1873 begins shift
  [1518-04-11 00:26] falls asleep
  [1518-11-10 00:24] wakes up
  [1518-09-12 00:39] wakes up
  [1518-11-07 00:19] falls asleep
  [1518-08-16 00:00] Guard #3187 begins shift
  [1518-05-06 00:41] falls asleep
  [1518-03-10 23:54] Guard #1789 begins shift
  [1518-10-01 00:11] falls asleep
  [1518-08-25 00:52] falls asleep
  [1518-03-17 00:57] falls asleep
  [1518-08-23 23:58] Guard #1069 begins shift
  [1518-07-20 00:56] wakes up
  [1518-08-22 00:48] wakes up
  [1518-05-31 00:40] falls asleep
  [1518-08-25 00:36] wakes up
  [1518-08-03 00:58] wakes up
  [1518-03-24 00:43] falls asleep
  [1518-06-17 00:11] falls asleep
  [1518-02-19 00:00] Guard #1873 begins shift
  [1518-04-17 00:01] falls asleep
  [1518-06-30 00:59] wakes up
  [1518-08-26 00:59] wakes up
  [1518-10-17 00:29] falls asleep
  [1518-07-11 00:00] Guard #2477 begins shift
  [1518-06-25 00:58] wakes up
  [1518-10-01 00:58] wakes up
  [1518-04-20 00:42] wakes up
  [1518-05-10 00:03] Guard #1901 begins shift
  [1518-03-10 00:51] falls asleep
  [1518-04-04 00:27] falls asleep
  [1518-02-26 00:45] wakes up
  [1518-08-03 00:00] Guard #2213 begins shift
  [1518-07-01 00:27] falls asleep
  [1518-04-04 00:14] wakes up
  [1518-08-25 00:25] falls asleep
  [1518-06-20 00:46] falls asleep
  [1518-07-23 23:59] Guard #1997 begins shift
  [1518-03-09 00:25] falls asleep
  [1518-09-19 00:48] falls asleep
  [1518-07-04 23:51] Guard #1607 begins shift
  [1518-08-04 00:21] wakes up
  [1518-07-18 00:51] wakes up
  [1518-09-23 23:57] Guard #3041 begins shift
  [1518-05-17 00:26] falls asleep
  [1518-06-26 00:01] Guard #1789 begins shift
  [1518-04-27 00:52] wakes up
  [1518-11-21 00:13] falls asleep
  [1518-07-23 00:12] falls asleep
  [1518-11-13 00:03] falls asleep
  [1518-07-10 00:15] falls asleep
  [1518-04-04 00:12] falls asleep
  [1518-03-24 23:54] Guard #3041 begins shift
  [1518-10-09 00:27] falls asleep
  [1518-08-09 00:36] wakes up
  [1518-10-04 00:45] falls asleep
  [1518-02-22 00:14] falls asleep
  [1518-08-03 00:57] falls asleep
  [1518-05-05 00:11] falls asleep
  [1518-07-08 00:00] Guard #1229 begins shift
  [1518-06-20 00:39] wakes up
  [1518-04-23 00:45] falls asleep
  [1518-02-25 00:53] wakes up
  [1518-08-20 00:09] wakes up
  [1518-04-24 00:42] falls asleep
  [1518-09-12 00:22] wakes up
  [1518-09-20 00:14] wakes up
  [1518-08-16 00:36] wakes up
  [1518-08-23 00:56] wakes up
  [1518-06-28 23:58] Guard #599 begins shift
  [1518-03-10 00:55] wakes up
  [1518-07-29 00:16] falls asleep
  [1518-09-04 00:55] falls asleep
  [1518-11-08 00:02] falls asleep
  [1518-03-22 00:04] Guard #1499 begins shift
  [1518-04-17 00:46] falls asleep
  [1518-07-05 00:00] falls asleep
  [1518-05-25 00:32] falls asleep
  [1518-07-02 23:56] Guard #1873 begins shift
  [1518-05-12 00:51] wakes up
  [1518-11-06 23:57] Guard #601 begins shift
  [1518-07-15 00:59] wakes up
  [1518-03-14 00:50] falls asleep
  [1518-02-14 00:01] Guard #2617 begins shift
  [1518-04-22 00:55] wakes up
  [1518-03-07 00:05] falls asleep
  [1518-10-28 00:22] falls asleep
  [1518-04-30 00:18] wakes up
  [1518-03-04 00:42] wakes up
  [1518-11-19 00:52] wakes up
  [1518-08-23 00:35] falls asleep
  [1518-10-13 00:59] wakes up
  [1518-11-22 00:18] falls asleep
  [1518-08-04 00:54] wakes up
  [1518-09-20 00:04] falls asleep
  [1518-11-12 00:37] falls asleep
  [1518-07-01 00:58] wakes up
  [1518-06-06 00:41] wakes up
  [1518-05-01 00:00] Guard #191 begins shift
  [1518-06-16 23:58] Guard #3187 begins shift
  [1518-06-17 23:54] Guard #1873 begins shift
  [1518-04-03 00:04] Guard #1069 begins shift
  [1518-04-19 00:32] wakes up
  [1518-05-30 00:25] falls asleep
  [1518-05-19 00:00] falls asleep
  [1518-09-13 00:32] wakes up
  [1518-07-20 00:47] wakes up
  [1518-05-18 00:15] falls asleep
  [1518-10-20 23:58] Guard #191 begins shift
  [1518-05-26 00:54] wakes up
  [1518-04-09 00:30] falls asleep
  [1518-06-22 23:58] Guard #1901 begins shift
  [1518-05-07 00:21] wakes up
  [1518-10-11 00:22] falls asleep
  [1518-05-23 00:08] falls asleep
  [1518-03-01 00:43] falls asleep
  [1518-06-03 00:59] wakes up
  [1518-09-07 00:04] Guard #2441 begins shift
  [1518-11-07 23:46] Guard #599 begins shift
  [1518-06-28 00:51] wakes up
  [1518-09-17 23:48] Guard #2207 begins shift
  [1518-08-21 00:29] wakes up
  [1518-05-02 00:41] falls asleep
  [1518-08-20 00:04] falls asleep
  [1518-06-25 00:31] falls asleep
  [1518-07-13 23:57] Guard #2617 begins shift
  [1518-03-16 00:13] falls asleep
  [1518-10-21 00:46] wakes up
  [1518-07-17 00:03] falls asleep
  [1518-09-11 23:58] Guard #1229 begins shift
  [1518-09-18 00:54] wakes up
  [1518-03-01 00:31] wakes up
  [1518-11-13 00:32] wakes up
  [1518-06-08 00:42] falls asleep
  [1518-06-18 00:13] wakes up
  [1518-09-10 00:16] falls asleep
  [1518-11-15 00:01] Guard #2221 begins shift
  [1518-07-13 00:18] falls asleep
  [1518-08-15 00:23] wakes up
  [1518-10-03 00:47] wakes up
  [1518-03-19 23:58] Guard #601 begins shift
  [1518-07-29 23:46] Guard #1789 begins shift
  [1518-08-16 00:41] falls asleep
  [1518-07-15 00:43] falls asleep
  [1518-10-19 23:59] Guard #2617 begins shift
  [1518-03-16 00:34] wakes up
  [1518-08-24 00:45] wakes up
  [1518-10-09 00:54] falls asleep
  [1518-02-23 00:37] falls asleep
  [1518-04-29 00:20] wakes up
  [1518-02-21 00:00] Guard #3167 begins shift
  [1518-08-25 00:57] wakes up
  [1518-06-20 00:34] falls asleep
  [1518-04-30 00:00] Guard #3041 begins shift
  [1518-05-16 00:52] wakes up
  [1518-02-24 00:35] wakes up
  [1518-11-05 23:59] Guard #601 begins shift
  [1518-11-22 00:43] wakes up
  [1518-10-18 00:44] wakes up
  [1518-07-17 00:38] falls asleep
  [1518-09-02 00:02] falls asleep
  [1518-07-01 00:55] falls asleep
  [1518-11-13 00:44] falls asleep
  [1518-08-28 23:56] Guard #1229 begins shift
  [1518-10-03 00:46] falls asleep
  [1518-07-30 23:59] Guard #2281 begins shift
  [1518-06-02 23:47] Guard #2477 begins shift
  [1518-07-27 00:52] wakes up
  [1518-09-13 23:57] Guard #2477 begins shift
  [1518-03-17 00:58] wakes up
  [1518-10-07 00:52] wakes up
  [1518-11-08 23:53] Guard #2617 begins shift
  [1518-03-29 00:51] wakes up
  [1518-04-02 00:39] wakes up
  [1518-03-29 23:59] Guard #2281 begins shift
  [1518-10-16 00:44] wakes up
  [1518-07-26 00:53] wakes up
  [1518-11-04 00:18] wakes up
  [1518-10-10 00:56] wakes up
  [1518-10-08 00:58] wakes up
  [1518-09-15 00:00] Guard #1069 begins shift
  [1518-11-17 00:26] falls asleep
  [1518-06-16 00:54] wakes up
  [1518-10-04 00:03] Guard #2617 begins shift
  [1518-03-28 00:15] falls asleep
  [1518-09-27 00:16] wakes up
  [1518-11-02 00:00] Guard #1901 begins shift
  [1518-08-01 23:53] Guard #1069 begins shift
  [1518-10-11 00:52] falls asleep
  [1518-04-09 00:03] Guard #3041 begins shift
  [1518-06-07 00:50] wakes up
  [1518-08-01 00:23] wakes up
  [1518-02-14 00:53] falls asleep
  [1518-05-20 00:44] wakes up
  [1518-05-06 23:57] Guard #3187 begins shift
  [1518-08-17 00:54] falls asleep
  [1518-10-09 00:55] wakes up
  [1518-03-27 00:25] wakes up
  [1518-03-11 23:53] Guard #601 begins shift
  [1518-05-05 00:40] wakes up
  [1518-11-18 23:58] Guard #3041 begins shift
  [1518-04-04 00:56] wakes up
  [1518-08-18 00:34] wakes up
  [1518-04-26 00:45] wakes up
  [1518-03-18 23:57] Guard #3187 begins shift
  [1518-10-13 00:00] Guard #2617 begins shift
  [1518-03-18 00:15] falls asleep
  [1518-03-13 00:44] falls asleep
  [1518-04-28 00:06] falls asleep
  [1518-04-12 00:01] Guard #191 begins shift
  [1518-09-19 00:27] wakes up
  [1518-10-24 23:59] Guard #1997 begins shift
  [1518-08-27 00:31] wakes up
  [1518-02-19 00:12] falls asleep
  [1518-06-09 00:37] falls asleep
  [1518-08-16 23:57] Guard #1789 begins shift
  [1518-04-01 00:38] wakes up
  [1518-05-07 23:51] Guard #1499 begins shift
  [1518-08-03 00:52] wakes up
  [1518-11-12 00:48] wakes up
  [1518-04-21 23:54] Guard #2441 begins shift
  [1518-05-18 23:49] Guard #1789 begins shift
  [1518-03-11 00:44] wakes up
  [1518-06-18 00:51] wakes up
  [1518-04-23 23:57] Guard #191 begins shift
  [1518-07-04 00:23] falls asleep
  [1518-04-04 00:03] Guard #2213 begins shift
  [1518-10-18 00:19] falls asleep
  [1518-07-29 00:44] wakes up
  [1518-02-16 00:21] falls asleep
  [1518-05-12 00:08] falls asleep
  [1518-08-19 00:00] Guard #2281 begins shift
  [1518-06-08 00:03] Guard #1873 begins shift
  [1518-05-23 00:57] falls asleep
  [1518-09-03 00:26] wakes up
  [1518-06-09 00:44] wakes up
  [1518-03-22 00:28] falls asleep
  [1518-11-23 00:45] wakes up
  [1518-11-16 00:45] falls asleep
  [1518-04-28 00:43] wakes up
  [1518-06-18 00:29] falls asleep
  [1518-07-22 00:04] Guard #2441 begins shift
  [1518-06-13 00:05] falls asleep
  [1518-08-01 00:03] Guard #2617 begins shift
  [1518-03-11 00:52] falls asleep
  [1518-03-11 00:27] wakes up
  [1518-02-24 00:13] falls asleep
  [1518-10-27 23:58] Guard #2477 begins shift
  [1518-02-18 00:54] wakes up
  [1518-10-02 00:48] wakes up
  [1518-06-15 00:45] falls asleep
  [1518-07-20 00:54] falls asleep
  [1518-09-22 00:02] Guard #3041 begins shift
  [1518-02-24 00:47] falls asleep
  [1518-06-25 00:21] wakes up
  [1518-11-22 00:04] Guard #2441 begins shift
  [1518-06-16 00:52] falls asleep
  [1518-05-23 00:09] wakes up
  [1518-11-04 00:04] falls asleep
  [1518-09-03 00:34] falls asleep
  [1518-11-14 00:12] falls asleep
  [1518-05-02 00:38] wakes up
  [1518-09-05 00:26] falls asleep
  [1518-11-09 00:46] falls asleep
  [1518-03-21 00:25] falls asleep
  [1518-06-18 00:42] wakes up
  [1518-07-05 00:41] wakes up
  [1518-07-05 23:58] Guard #2213 begins shift
  [1518-03-25 00:58] wakes up
  [1518-06-06 00:03] Guard #2207 begins shift
  [1518-04-17 00:30] falls asleep
  [1518-11-23 00:21] falls asleep
  [1518-08-20 00:57] wakes up
  [1518-03-08 00:46] falls asleep
  [1518-06-29 00:55] falls asleep
  [1518-02-17 00:54] falls asleep
  [1518-07-28 00:29] falls asleep
  [1518-07-13 00:37] wakes up
  [1518-05-01 00:10] falls asleep
  [1518-02-15 23:59] Guard #3041 begins shift
  [1518-10-05 00:34] falls asleep
  [1518-03-18 00:41] wakes up
  [1518-03-02 00:55] wakes up
  [1518-08-06 23:59] Guard #3167 begins shift
  [1518-04-22 00:53] falls asleep
  [1518-05-06 00:36] wakes up
  [1518-06-18 00:46] falls asleep
  [1518-05-23 00:49] wakes up
  [1518-10-19 00:13] falls asleep
  [1518-05-13 00:39] wakes up
  [1518-04-29 00:56] wakes up
  [1518-05-18 00:03] falls asleep
  [1518-02-23 00:31] wakes up
  [1518-08-30 23:56] Guard #2207 begins shift
  [1518-08-18 00:04] Guard #1789 begins shift
  [1518-10-21 00:17] falls asleep
  [1518-05-25 00:52] wakes up
  [1518-10-12 00:18] wakes up
  [1518-04-03 00:41] falls asleep
  [1518-02-26 00:24] wakes up
  [1518-05-16 00:02] Guard #1789 begins shift
  [1518-11-15 23:57] Guard #2213 begins shift
  [1518-03-23 00:57] falls asleep
  [1518-04-13 00:58] wakes up
  [1518-02-17 00:58] wakes up
  [1518-08-13 23:59] Guard #1031 begins shift
  [1518-07-26 00:02] Guard #191 begins shift
  [1518-03-11 00:42] falls asleep
  [1518-10-15 00:50] wakes up
  [1518-06-26 00:52] wakes up
  [1518-04-22 00:47] wakes up
  [1518-11-05 00:49] wakes up
  [1518-07-03 00:51] wakes up
  [1518-07-22 00:39] falls asleep
  [1518-03-24 00:47] wakes up
  [1518-10-28 00:31] wakes up
  [1518-11-09 00:54] falls asleep
  [1518-09-19 23:52] Guard #1607 begins shift
  [1518-03-17 00:51] wakes up
  [1518-09-10 00:56] wakes up
  [1518-04-17 00:19] wakes up
  [1518-11-23 00:00] Guard #1499 begins shift
  [1518-04-22 00:03] falls asleep
  [1518-05-21 00:34] wakes up
  [1518-05-07 00:18] falls asleep
  [1518-03-13 00:37] wakes up
  [1518-06-04 00:54] falls asleep
  [1518-02-22 00:35] wakes up
  [1518-04-30 00:07] falls asleep
  [1518-08-09 00:30] falls asleep
  [1518-09-21 00:44] wakes up
  [1518-04-29 00:24] falls asleep
  [1518-08-24 00:08] falls asleep
  [1518-09-21 00:06] wakes up
  [1518-04-16 23:50] Guard #2281 begins shift
  [1518-07-12 00:59] wakes up
  [1518-10-03 00:03] Guard #1229 begins shift
  [1518-06-12 23:49] Guard #1069 begins shift
  [1518-07-26 00:44] falls asleep
  [1518-07-25 00:58] wakes up
  [1518-05-20 00:10] falls asleep
  [1518-05-02 00:44] wakes up
  [1518-09-29 00:58] wakes up
  [1518-04-28 00:02] Guard #1901 begins shift
  [1518-06-25 00:09] falls asleep
  [1518-05-13 23:47] Guard #601 begins shift
  [1518-02-15 00:25] wakes up
  [1518-09-05 00:00] Guard #1607 begins shift
  [1518-09-15 00:32] wakes up
  [1518-05-10 23:56] Guard #1873 begins shift
  [1518-08-28 00:39] falls asleep
  [1518-10-27 00:07] falls asleep
  [1518-09-22 00:50] wakes up
  [1518-11-20 00:54] wakes up
  [1518-07-10 00:59] wakes up
  [1518-02-15 00:35] falls asleep
  [1518-06-16 00:00] falls asleep
  [1518-03-13 00:07] falls asleep
  [1518-05-08 00:50] wakes up
  [1518-09-08 00:58] wakes up
  [1518-07-14 00:59] wakes up
  [1518-04-10 00:39] falls asleep
  [1518-04-21 00:34] falls asleep
  [1518-04-15 00:25] falls asleep
  [1518-05-19 00:59] wakes up
  [1518-02-19 00:27] wakes up
  [1518-10-02 00:04] Guard #599 begins shift
  [1518-03-01 00:02] falls asleep
  [1518-04-28 00:47] falls asleep
  [1518-08-21 00:05] falls asleep
  [1518-07-28 00:05] falls asleep
  [1518-10-31 23:57] Guard #1031 begins shift
  [1518-10-14 00:37] falls asleep
  [1518-09-25 00:02] falls asleep
  [1518-05-17 00:00] Guard #1229 begins shift
  [1518-03-14 00:53] wakes up
  [1518-07-15 00:55] falls asleep
  [1518-03-30 00:37] wakes up
  [1518-03-22 23:58] Guard #191 begins shift
  [1518-03-16 00:42] falls asleep
  [1518-11-02 00:49] wakes up
  [1518-11-09 00:55] wakes up
  [1518-08-16 00:30] falls asleep
  [1518-10-24 00:37] falls asleep
  [1518-11-12 00:26] falls asleep
  [1518-09-13 00:58] wakes up
  [1518-06-12 00:04] Guard #3041 begins shift
  [1518-07-24 00:17] falls asleep
  [1518-11-05 00:35] falls asleep
  [1518-07-30 00:36] wakes up
  [1518-09-30 00:58] wakes up
  [1518-04-14 00:01] Guard #2213 begins shift
  [1518-02-26 00:32] falls asleep
  [1518-07-21 00:00] Guard #1997 begins shift
  [1518-11-17 00:00] Guard #1499 begins shift
  [1518-10-29 00:16] falls asleep
  [1518-10-08 00:00] Guard #1873 begins shift
  [1518-06-03 00:46] wakes up
  [1518-06-14 23:56] Guard #1103 begins shift
  [1518-06-06 00:49] falls asleep
  [1518-08-03 00:31] falls asleep
  [1518-10-13 00:36] falls asleep
  [1518-02-13 00:25] wakes up
  [1518-06-11 00:31] falls asleep
  [1518-11-04 00:54] wakes up
  [1518-05-09 00:47] falls asleep
  [1518-08-27 00:52] falls asleep
  [1518-09-16 00:47] wakes up
  [1518-10-10 00:29] wakes up
  [1518-02-26 00:16] falls asleep
  [1518-11-10 00:38] falls asleep
  [1518-05-27 00:00] Guard #1997 begins shift
  [1518-06-07 00:21] wakes up
  [1518-08-16 00:56] wakes up
  [1518-06-04 00:57] wakes up
  [1518-09-12 00:32] falls asleep
  [1518-08-31 00:15] falls asleep
  [1518-10-22 00:00] Guard #3187 begins shift
  [1518-04-12 00:40] falls asleep
  [1518-04-20 00:07] falls asleep
  [1518-07-11 00:55] wakes up
  [1518-07-09 00:01] falls asleep
  [1518-03-31 00:40] falls asleep
  [1518-05-12 00:55] falls asleep
  [1518-11-14 00:56] wakes up
  [1518-11-14 00:32] falls asleep
  [1518-06-24 00:41] falls asleep
  [1518-08-25 23:58] Guard #3041 begins shift
  [1518-07-06 00:59] wakes up
  [1518-03-05 00:02] Guard #1789 begins shift
  [1518-04-08 00:24] falls asleep
  [1518-05-23 00:00] Guard #2213 begins shift
  [1518-07-25 00:10] falls asleep
  [1518-11-02 00:12] falls asleep
  [1518-09-07 00:09] falls asleep
  [1518-04-16 00:50] wakes up
  [1518-07-18 00:06] falls asleep
  [1518-08-26 23:56] Guard #2617 begins shift
  [1518-08-13 00:00] Guard #2477 begins shift
  [1518-10-19 00:21] wakes up
  [1518-09-27 00:41] falls asleep
  [1518-04-09 00:55] wakes up
  [1518-03-05 00:33] wakes up
  [1518-10-08 00:51] falls asleep
  [1518-09-04 00:30] falls asleep
  [1518-09-23 00:15] wakes up
  [1518-03-04 00:55] wakes up
  [1518-07-10 00:04] Guard #1229 begins shift
  [1518-05-30 23:50] Guard #1873 begins shift
  [1518-10-08 00:24] falls asleep
  [1518-11-12 00:34] wakes up
  [1518-02-14 00:22] falls asleep
  [1518-04-14 00:58] wakes up
  [1518-05-14 00:49] falls asleep
  [1518-08-28 00:53] wakes up
  [1518-11-11 00:17] falls asleep
  [1518-09-19 00:00] Guard #2213 begins shift
  [1518-09-20 23:47] Guard #1873 begins shift
  [1518-09-24 23:53] Guard #2477 begins shift
  [1518-03-14 23:57] Guard #1103 begins shift
  [1518-02-24 00:00] Guard #1069 begins shift
  [1518-09-05 00:58] wakes up
  [1518-03-02 00:03] Guard #1997 begins shift
  [1518-04-17 00:41] wakes up
  [1518-02-13 00:05] falls asleep
  [1518-05-26 00:02] Guard #2441 begins shift
  [1518-05-20 00:56] wakes up
  [1518-09-07 23:56] Guard #1069 begins shift
  [1518-08-11 00:14] falls asleep
  [1518-09-19 00:23] falls asleep
  [1518-11-09 00:03] falls asleep
  [1518-11-10 00:58] wakes up
  [1518-04-06 00:13] falls asleep
  [1518-08-09 23:53] Guard #1229 begins shift
  [1518-10-26 00:52] wakes up
  [1518-11-17 00:51] wakes up
  [1518-06-27 23:47] Guard #1997 begins shift
  [1518-05-22 00:31] falls asleep
  [1518-06-15 00:22] falls asleep
  [1518-02-25 00:33] falls asleep
  [1518-05-31 00:03] falls asleep
  [1518-03-25 23:59] Guard #1789 begins shift
  [1518-09-28 00:25] falls asleep
  [1518-03-08 00:55] wakes up
  [1518-05-12 00:26] wakes up
  [1518-06-02 00:02] falls asleep
  [1518-08-10 00:39] falls asleep
  [1518-02-15 00:45] wakes up
  [1518-08-26 00:46] wakes up
  [1518-06-12 00:41] wakes up
  [1518-08-21 00:43] wakes up
  [1518-11-09 23:49] Guard #601 begins shift
  [1518-06-28 00:01] falls asleep
  [1518-09-02 00:45] wakes up
  [1518-03-09 00:44] falls asleep
  [1518-03-03 00:16] wakes up
  [1518-04-29 00:41] wakes up
  [1518-04-01 00:00] Guard #2477 begins shift
  [1518-03-08 00:01] Guard #1901 begins shift
  [1518-02-15 00:01] falls asleep
  [1518-03-12 00:00] falls asleep
  [1518-06-08 00:49] wakes up
  [1518-02-25 23:58] Guard #2441 begins shift
  [1518-06-27 00:00] Guard #1499 begins shift
  [1518-04-13 00:45] wakes up
  [1518-07-31 00:52] falls asleep
  [1518-05-07 00:54] wakes up
  [1518-07-28 00:26] wakes up
  [1518-03-18 00:55] wakes up
  [1518-07-11 00:19] falls asleep
  [1518-10-10 00:32] falls asleep
  [1518-07-01 00:47] wakes up
  [1518-04-26 00:54] falls asleep
  [1518-06-02 00:08] wakes up
  [1518-10-17 00:39] wakes up
  [1518-02-13 00:52] wakes up
  [1518-07-14 00:47] wakes up
  [1518-06-01 00:43] wakes up
  [1518-09-21 00:11] falls asleep
  [1518-05-28 00:19] falls asleep
  [1518-05-04 00:57] wakes up
  [1518-05-06 00:43] wakes up
  [1518-08-05 23:59] Guard #2281 begins shift
  [1518-09-27 23:59] Guard #1103 begins shift
  [1518-10-10 00:03] falls asleep
  [1518-09-23 00:00] Guard #1873 begins shift
  [1518-09-09 00:53] wakes up
  [1518-04-26 23:57] Guard #191 begins shift
  [1518-08-05 00:04] falls asleep
  [1518-04-17 00:55] wakes up
  [1518-05-17 23:48] Guard #1901 begins shift
  [1518-05-11 00:45] wakes up
  [1518-09-28 23:50] Guard #3041 begins shift
  [1518-03-09 00:01] Guard #1069 begins shift
  [1518-07-02 00:35] falls asleep
  [1518-10-14 00:02] Guard #2617 begins shift
  [1518-05-22 00:02] Guard #601 begins shift
  [1518-10-15 23:53] Guard #1607 begins shift
  [1518-04-08 00:00] Guard #601 begins shift
  [1518-05-09 00:04] Guard #191 begins shift
  [1518-04-25 00:19] falls asleep
  [1518-08-05 00:46] wakes up
  [1518-03-25 00:29] falls asleep
  [1518-02-17 00:45] wakes up
  [1518-03-23 23:57] Guard #1499 begins shift
  [1518-08-10 00:53] wakes up
  [1518-05-20 00:52] falls asleep
  [1518-06-14 00:25] wakes up
  [1518-11-10 00:50] wakes up
  [1518-09-03 00:02] falls asleep
  [1518-04-06 00:00] Guard #2207 begins shift
  [1518-04-18 23:59] Guard #1901 begins shift
  [1518-06-25 00:44] wakes up
  [1518-06-10 23:58] Guard #2477 begins shift
  [1518-06-08 00:55] wakes up
  [1518-03-31 00:49] wakes up
  [1518-04-14 00:19] falls asleep
  [1518-06-26 00:24] wakes up
  [1518-10-23 23:56] Guard #1789 begins shift
  [1518-03-17 00:00] Guard #3187 begins shift
  [1518-03-27 00:13] falls asleep
  [1518-10-03 00:51] falls asleep
  [1518-09-28 00:55] wakes up
  [1518-07-22 00:55] falls asleep
  [1518-03-09 00:41] wakes up
  [1518-03-06 00:21] falls asleep
  [1518-05-29 00:37] wakes up
  [1518-05-08 00:04] falls asleep
  [1518-05-24 00:58] wakes up
  [1518-10-02 00:30] falls asleep
  [1518-07-15 00:52] wakes up
  [1518-06-08 00:52] falls asleep
  [1518-09-29 23:58] Guard #2617 begins shift
  [1518-09-16 00:46] falls asleep
  [1518-07-08 00:50] wakes up
  [1518-03-05 23:59] Guard #1069 begins shift
  [1518-07-14 23:58] Guard #2213 begins shift
  [1518-05-01 00:51] wakes up
  [1518-09-02 23:54] Guard #1901 begins shift
  [1518-08-12 00:55] wakes up
  [1518-06-06 00:52] wakes up
  [1518-08-17 00:46] wakes up
  [1518-06-05 00:00] Guard #2617 begins shift
  [1518-02-28 00:12] falls asleep
  [1518-10-09 00:04] Guard #1901 begins shift
  [1518-05-17 00:59] wakes up
  [1518-08-23 00:01] Guard #3041 begins shift
  [1518-06-04 00:09] falls asleep
  [1518-10-29 00:52] wakes up
  [1518-07-13 00:00] Guard #1789 begins shift
  [1518-08-10 00:25] wakes up
  [1518-03-03 00:13] falls asleep
  [1518-04-21 00:02] Guard #2441 begins shift
  [1518-06-05 00:56] wakes up
  [1518-02-26 00:38] falls asleep
  [1518-06-01 23:53] Guard #1873 begins shift
  [1518-11-08 00:45] wakes up
  [1518-03-03 23:57] Guard #2281 begins shift
  [1518-09-21 00:04] falls asleep
  [1518-11-12 23:54] Guard #191 begins shift
  [1518-03-12 00:39] wakes up
  [1518-09-26 00:01] Guard #2477 begins shift
  [1518-10-04 00:58] wakes up
  [1518-08-02 00:38] wakes up
  [1518-04-29 00:13] falls asleep
  [1518-03-11 00:04] falls asleep
  [1518-07-01 23:54] Guard #1069 begins shift
  [1518-10-12 00:13] falls asleep
  [1518-03-07 00:55] wakes up
  [1518-10-14 23:58] Guard #2213 begins shift
  [1518-06-25 00:51] falls asleep
  [1518-04-10 00:40] wakes up
  [1518-03-29 00:42] falls asleep
  [1518-10-23 00:48] wakes up
  [1518-02-14 00:29] wakes up
  [1518-02-17 00:04] Guard #1873 begins shift
  [1518-04-15 00:34] wakes up
  [1518-05-12 00:03] Guard #3041 begins shift
  [1518-09-15 00:17] falls asleep
  [1518-10-17 00:50] wakes up
  [1518-10-16 00:40] falls asleep
  [1518-06-10 00:54] falls asleep
  [1518-04-07 00:55] falls asleep
  [1518-10-13 00:49] wakes up
  [1518-05-06 00:46] falls asleep
  [1518-09-14 00:51] wakes up
  [1518-11-18 00:52] wakes up
  [1518-08-19 23:47] Guard #1607 begins shift
  [1518-05-07 00:53] falls asleep
  [1518-03-15 00:33] falls asleep
  [1518-09-24 00:39] falls asleep
  [1518-07-19 00:53] wakes up
  [1518-11-05 00:11] falls asleep
  [1518-08-11 00:19] wakes up
  [1518-08-29 00:53] wakes up
  [1518-10-20 00:30] falls asleep
  [1518-02-24 23:59] Guard #2213 begins shift
  [1518-03-03 00:04] Guard #2281 begins shift
  [1518-11-05 00:20] wakes up
  [1518-02-14 00:50] wakes up
  [1518-08-15 00:20] falls asleep
  [1518-09-29 00:01] falls asleep
  [1518-05-10 00:48] wakes up
  [1518-07-07 00:04] Guard #3167 begins shift
  [1518-02-26 23:57] Guard #2441 begins shift
  [1518-11-08 00:14] falls asleep
  [1518-06-15 23:51] Guard #1499 begins shift
  [1518-05-20 00:04] Guard #3041 begins shift
  [1518-09-30 00:46] falls asleep
  [1518-11-07 00:54] wakes up
  [1518-05-15 00:04] falls asleep
  [1518-06-26 00:28] falls asleep
  [1518-09-23 00:53] wakes up
  [1518-03-12 23:56] Guard #1607 begins shift
  [1518-06-23 00:09] falls asleep
  [1518-10-16 00:16] falls asleep
  [1518-08-08 00:44] falls asleep
  [1518-11-20 00:08] falls asleep
  [1518-09-13 00:25] falls asleep
  [1518-09-09 00:58] wakes up
  [1518-09-14 00:49] falls asleep
  [1518-05-14 00:41] wakes up
  [1518-09-29 00:41] wakes up
  [1518-04-25 23:46] Guard #1997 begins shift
  [1518-05-31 00:53] wakes up
  [1518-02-18 00:31] falls asleep
  [1518-03-22 00:43] wakes up
  [1518-11-03 23:50] Guard #1901 begins shift
  [1518-03-24 00:55] wakes up
  [1518-10-14 00:56] falls asleep
  [1518-05-27 00:12] falls asleep
  [1518-06-30 00:02] Guard #2441 begins shift
  [1518-06-21 00:07] falls asleep
  [1518-10-09 23:54] Guard #1873 begins shift
  [1518-08-17 00:58] wakes up
  [1518-07-18 00:04] Guard #1997 begins shift
  [1518-08-27 00:21] falls asleep
  [1518-05-05 23:59] Guard #1789 begins shift
  [1518-06-18 00:00] falls asleep
  [1518-03-21 00:47] wakes up
  [1518-11-10 00:01] falls asleep
  [1518-06-23 00:47] wakes up
  [1518-10-13 00:29] wakes up
  [1518-07-11 23:57] Guard #1069 begins shift
  [1518-10-25 00:20] wakes up
  [1518-10-23 00:10] falls asleep
  [1518-10-12 00:01] Guard #1997 begins shift
  [1518-07-31 00:19] falls asleep
  [1518-05-02 00:54] falls asleep
  [1518-10-31 00:00] Guard #2441 begins shift
  [1518-09-24 00:56] wakes up
  [1518-10-07 00:01] Guard #3041 begins shift
  [1518-10-24 00:59] wakes up
  [1518-06-20 00:02] Guard #599 begins shift
  [1518-03-23 00:58] wakes up
  [1518-06-10 00:49] wakes up
  [1518-04-01 00:25] wakes up
  [1518-07-02 00:50] wakes up
  [1518-04-24 00:50] falls asleep
  [1518-10-17 00:04] Guard #1499 begins shift
  [1518-08-20 00:42] falls asleep
  [1518-07-28 00:50] wakes up
  [1518-02-14 00:47] falls asleep
  [1518-02-16 00:47] wakes up
  [1518-10-19 00:03] Guard #1607 begins shift
  [1518-08-27 23:59] Guard #1229 begins shift
  [1518-03-18 00:54] falls asleep
  [1518-02-28 00:51] wakes up
  [1518-09-23 00:30] wakes up
  [1518-04-06 00:47] wakes up
  [1518-06-03 23:56] Guard #601 begins shift
  [1518-06-21 00:00] Guard #3041 begins shift
  [1518-07-24 00:54] falls asleep
  [1518-10-26 00:31] falls asleep
  [1518-09-16 23:52] Guard #601 begins shift
  [1518-06-01 00:14] falls asleep
  [1518-10-30 00:47] wakes up
  [1518-07-06 00:21] falls asleep
  [1518-03-14 00:07] falls asleep
  [1518-10-22 00:42] wakes up
  [1518-05-30 00:57] wakes up
  [1518-08-26 00:50] falls asleep
  [1518-03-01 00:56] wakes up
  [1518-05-16 00:49] falls asleep
  [1518-06-18 23:58] Guard #1103 begins shift
  [1518-06-19 00:38] wakes up
  [1518-05-13 00:30] falls asleep
  [1518-07-25 00:48] falls asleep
  [1518-10-11 00:59] wakes up
  [1518-03-23 00:45] wakes up
  [1518-07-21 00:11] falls asleep
  [1518-08-11 23:58] Guard #2207 begins shift
  [1518-08-04 00:42] falls asleep
  [1518-07-16 23:48] Guard #1499 begins shift
  [1518-08-18 00:24] falls asleep
  [1518-07-26 23:56] Guard #1499 begins shift
  [1518-06-30 00:55] falls asleep
  [1518-05-12 00:59] wakes up
  [1518-02-27 00:20] falls asleep
  [1518-07-21 00:26] wakes up
  [1518-04-28 00:59] wakes up
  [1518-06-22 00:10] falls asleep
  [1518-10-13 00:54] falls asleep
  [1518-10-17 00:43] falls asleep
  [1518-06-30 00:22] falls asleep
  [1518-05-14 00:01] falls asleep
  [1518-03-25 00:04] falls asleep
  [1518-03-04 00:32] falls asleep
  [1518-10-30 00:19] falls asleep
  [1518-07-31 00:57] wakes up
  [1518-07-28 23:58] Guard #1997 begins shift
  [1518-07-19 00:00] Guard #3041 begins shift
  [1518-08-26 00:34] falls asleep
  [1518-04-01 00:37] falls asleep
  [1518-09-17 00:02] falls asleep
  [1518-03-11 00:56] wakes up
  [1518-03-10 00:04] Guard #1069 begins shift
  [1518-06-10 00:00] Guard #1229 begins shift
  [1518-04-16 00:23] falls asleep
  [1518-03-09 00:59] wakes up
  [1518-03-26 00:45] wakes up
  [1518-09-04 00:45] wakes up
  [1518-09-27 00:01] Guard #1069 begins shift
  [1518-04-13 00:16] falls asleep
  [1518-09-03 23:58] Guard #2617 begins shift
  [1518-09-23 00:38] falls asleep
  [1518-09-09 00:56] falls asleep
  [1518-04-05 00:28] wakes up
  [1518-11-10 00:57] falls asleep
  [1518-07-25 00:34] wakes up
  [1518-05-27 00:34] wakes up
  [1518-06-29 00:40] falls asleep
  [1518-09-09 00:03] Guard #1901 begins shift
  [1518-03-04 00:53] falls asleep
  [1518-06-24 00:55] wakes up
  [1518-02-23 00:53] wakes up
  [1518-07-29 00:58] wakes up
  [1518-10-12 00:59] wakes up
  [1518-06-07 00:00] Guard #2213 begins shift
  [1518-10-26 00:01] Guard #1901 begins shift
  [1518-05-24 23:57] Guard #2281 begins shift
  [1518-09-17 00:47] wakes up
  [1518-06-26 00:21] falls asleep
  [1518-09-01 00:48] wakes up
  [1518-03-02 00:12] falls asleep
  [1518-05-04 23:56] Guard #1789 begins shift
  [1518-05-22 00:41] wakes up
  [1518-04-19 00:51] wakes up
  [1518-08-21 00:35] falls asleep
  [1518-03-13 00:13] wakes up
  [1518-04-13 00:04] Guard #2441 begins shift
  [1518-04-01 00:55] wakes up
  [1518-09-19 00:57] wakes up
  [1518-03-06 23:46] Guard #1997 begins shift
  [1518-05-09 00:55] wakes up
  [1518-03-17 23:57] Guard #2207 begins shift
  [1518-06-07 00:06] falls asleep
  [1518-11-16 00:57] wakes up
  [1518-05-24 00:04] Guard #2477 begins shift
  [1518-05-26 00:23] falls asleep
  [1518-10-06 00:38] falls asleep
  [1518-09-04 00:57] wakes up
  [1518-05-10 00:46] falls asleep
  [1518-06-07 00:45] falls asleep
  [1518-06-21 00:58] wakes up
  [1518-08-22 00:35] falls asleep
  [1518-04-13 00:54] falls asleep
  [1518-04-24 00:57] wakes up
  [1518-07-22 00:57] wakes up
  [1518-10-16 00:02] falls asleep
  [1518-03-13 23:57] Guard #1069 begins shift
  [1518-07-04 00:56] wakes up
  [1518-02-22 00:39] falls asleep
  [1518-11-09 00:35] wakes up
  [1518-03-21 00:00] Guard #1873 begins shift
  [1518-02-22 23:59] Guard #1901 begins shift
  [1518-10-09 00:48] wakes up
  [1518-05-24 00:20] falls asleep
  [1518-10-20 00:58] wakes up
  [1518-03-20 00:30] wakes up
  [1518-07-22 00:52] wakes up
  [1518-09-23 00:11] falls asleep
  [1518-06-10 00:57] wakes up
  [1518-04-27 00:46] falls asleep
  [1518-07-10 00:57] falls asleep
  [1518-05-04 00:01] falls asleep
  [1518-03-29 00:38] wakes up
  [1518-03-06 00:39] wakes up
  [1518-07-03 00:38] wakes up
  [1518-04-16 00:01] Guard #1789 begins shift
  [1518-07-01 00:01] Guard #1607 begins shift
  [1518-05-14 00:53] wakes up
  [1518-07-02 00:25] wakes up
  [1518-07-22 23:56] Guard #1499 begins shift
  [1518-08-10 00:04] falls asleep
  [1518-02-17 00:21] falls asleep
  [1518-06-30 00:47] wakes up
  [1518-10-11 00:03] Guard #2213 begins shift
  [1518-05-06 00:27] falls asleep
  [1518-05-21 00:32] falls asleep
  [1518-05-18 00:06] wakes up
  [1518-09-23 00:28] falls asleep
  [1518-04-19 23:59] Guard #1997 begins shift
  [1518-10-05 00:58] wakes up
  [1518-10-22 00:18] falls asleep
  [1518-02-22 00:00] Guard #191 begins shift
  [1518-04-10 00:04] Guard #2281 begins shift
  [1518-08-25 00:00] Guard #2207 begins shift
  [1518-09-29 00:50] falls asleep
  [1518-06-08 23:58] Guard #191 begins shift
  [1518-06-02 00:40] falls asleep
  [1518-05-01 23:58] Guard #2441 begins shift
  [1518-02-14 00:56] wakes up
  [1518-04-19 00:11] falls asleep
  [1518-05-28 00:40] wakes up
  [1518-03-28 00:45] wakes up
  [1518-05-03 23:48] Guard #1103 begins shift
  [1518-04-04 23:47] Guard #1873 begins shift
  [1518-09-09 00:52] falls asleep
  [1518-11-11 00:42] wakes up
  [1518-10-31 00:25] falls asleep
  [1518-08-06 00:16] falls asleep
  [1518-04-29 00:47] falls asleep
  [1518-06-15 00:35] wakes up
  [1518-08-27 00:56] wakes up
  [1518-03-26 23:59] Guard #3041 begins shift
  [1518-05-30 00:01] Guard #1607 begins shift
  [1518-06-01 00:00] Guard #2617 begins shift
  [1518-04-17 23:58] Guard #1873 begins shift
  [1518-11-17 23:59] Guard #599 begins shift
  [1518-11-11 23:59] Guard #1069 begins shift
  [1518-07-24 00:22] wakes up
  [1518-08-30 00:34] wakes up
  [1518-05-27 23:59] Guard #3041 begins shift
  [1518-08-11 00:59] wakes up
  [1518-11-02 23:57] Guard #2213 begins shift
  [1518-03-16 00:03] Guard #3041 begins shift
  [1518-07-21 00:40] falls asleep
  [1518-06-06 00:30] falls asleep
  [1518-11-13 23:57] Guard #2207 begins shift
  [1518-10-25 00:15] falls asleep
  [1518-02-17 23:56] Guard #2281 begins shift
  [1518-03-27 23:57] Guard #1901 begins shift
  [1518-11-21 00:33] wakes up
  [1518-04-01 00:21] falls asleep
  [1518-10-06 00:58] wakes up
  [1518-03-16 00:32] falls asleep
  [1518-08-09 00:58] wakes up
  [1518-05-18 00:53] wakes up
  [1518-08-06 00:37] wakes up
  [1518-11-06 00:40] wakes up
  [1518-07-29 00:52] falls asleep
  [1518-05-11 00:30] falls asleep
  [1518-05-21 00:03] Guard #1229 begins shift
  [1518-08-04 23:53] Guard #1901 begins shift
  [1518-02-19 23:56] Guard #3167 begins shift
  [1518-09-27 00:44] wakes up
  [1518-08-08 00:04] Guard #191 begins shift
  [1518-08-20 23:52] Guard #1997 begins shift
  [1518-02-27 00:58] wakes up
  [1518-07-04 00:02] Guard #1069 begins shift
  [1518-05-02 00:55] wakes up
  [1518-02-12 23:50] Guard #1789 begins shift
  [1518-09-12 23:58] Guard #2213 begins shift
  [1518-06-12 00:32] falls asleep
  [1518-04-08 00:46] wakes up
  [1518-07-05 00:05] wakes up
  [1518-03-25 00:21] wakes up
  [1518-11-19 00:38] falls asleep
  [1518-11-10 23:57] Guard #1997 begins shift
  [1518-06-03 00:50] falls asleep
  [1518-05-29 00:01] Guard #2441 begins shift
  [1518-07-24 00:57] wakes up
  [1518-09-13 00:46] falls asleep
  [1518-09-06 00:10] falls asleep
  [1518-07-19 00:33] falls asleep
  [1518-06-13 00:42] wakes up
  [1518-07-04 00:32] falls asleep
  [1518-03-15 00:58] wakes up
  [1518-04-26 00:56] wakes up
  [1518-04-02 00:25] falls asleep
  [1518-06-17 00:44] wakes up
  [1518-09-10 23:59] Guard #3167 begins shift
  [1518-03-13 00:54] wakes up
  [1518-07-05 00:25] falls asleep
  [1518-10-04 23:57] Guard #1901 begins shift
  [1518-11-04 23:57] Guard #2281 begins shift
  [1518-08-03 23:59] Guard #1997 begins shift
  [1518-08-13 00:47] falls asleep
  [1518-09-12 00:06] falls asleep
  [1518-03-30 00:35] falls asleep
  [1518-07-04 00:26] wakes up
  [1518-10-01 00:02] Guard #2281 begins shift
  [1518-03-24 00:51] falls asleep
  [1518-08-11 00:48] falls asleep
  [1518-03-20 00:11] falls asleep
  [1518-07-10 00:48] wakes up
  [1518-09-25 00:33] wakes up
  [1518-10-25 00:54] wakes up
  [1518-08-09 00:51] falls asleep
  [1518-02-28 23:50] Guard #1607 begins shift
  [1518-06-22 00:17] wakes up
  [1518-08-29 23:47] Guard #2477 begins shift
  [1518-04-22 23:56] Guard #1997 begins shift
  [1518-09-27 00:07] falls asleep
  [1518-07-09 00:28] wakes up
  [1518-09-05 23:57] Guard #1873 begins shift
  [1518-06-03 00:04] falls asleep
  [1518-06-04 00:29] wakes up
  [1518-11-18 00:07] falls asleep
  [1518-10-16 00:17] wakes up
  [1518-08-28 00:23] falls asleep
  [1518-05-02 00:35] falls asleep
  [1518-05-27 00:51] wakes up
  [1518-05-12 23:59] Guard #2441 begins shift
  [1518-09-26 00:24] falls asleep
  [1518-07-14 00:23] falls asleep
  [1518-10-05 23:56] Guard #2207 begins shift
  [1518-09-18 00:05] falls asleep
  [1518-03-05 00:19] falls asleep
  [1518-02-24 00:56] wakes up
  [1518-10-17 23:56] Guard #1789 begins shift
  [1518-09-01 00:00] Guard #1103 begins shift
  [1518-10-13 00:10] falls asleep
  [1518-03-26 00:41] falls asleep
  [1518-07-03 00:20] falls asleep
  [1518-02-26 00:34] wakes up
  [1518-06-20 00:55] wakes up
  [1518-09-10 00:02] Guard #191 begins shift
  [1518-07-25 00:01] Guard #1229 begins shift
  [1518-06-15 00:59] wakes up
  [1518-08-21 23:58] Guard #2477 begins shift
  [1518-04-07 00:02] Guard #1229 begins shift
  [1518-04-03 00:55] wakes up
  [1518-06-13 23:59] Guard #1069 begins shift
  [1518-03-13 00:26] falls asleep
  [1518-10-22 23:59] Guard #2617 begins shift
  [1518-08-28 00:33] wakes up
  [1518-07-17 00:34] wakes up
  [1518-03-03 00:41] falls asleep
  [1518-09-03 00:14] falls asleep
  [1518-08-13 00:57] wakes up
  [1518-10-15 00:48] falls asleep
  [1518-04-01 23:58] Guard #1789 begins shift
  [1518-11-14 00:28] wakes up
  [1518-06-24 00:02] Guard #1499 begins shift
  [1518-08-02 00:04] falls asleep
  [1518-10-16 00:12] wakes up
  [1518-05-23 00:58] wakes up
  [1518-06-27 00:21] falls asleep
  [1518-10-27 00:00] Guard #1901 begins shift
  [1518-09-01 00:35] falls asleep
  [1518-06-24 23:58] Guard #2213 begins shift
  [1518-11-03 00:53] wakes up
  [1518-05-29 00:07] falls asleep
  [1518-04-25 00:54] wakes up
  [1518-04-11 00:50] wakes up
  [1518-03-28 23:59] Guard #3041 begins shift
  [1518-03-23 00:15] falls asleep
  [1518-04-23 00:14] falls asleep
  [1518-07-27 23:47] Guard #2617 begins shift
  [1518-02-23 00:22] falls asleep
  [1518-04-26 00:01] falls asleep
  [1518-04-07 00:59] wakes up")

(def formatter (f/formatter "yyyy-MM-dd HH:mm"))

(def event
  "[1518-05-27 00:42] falls asleep")

(defn parse-date
  [event]
  (let [date (subs event 1 17)]
    (f/parse formatter date)))

(defn parse-event
  [event]
  {:event (subs event 19)
   :date (parse-date event)})

(defn parse-events
  [input]
  (->> (clojure.string/split input #"\n")
       (map clojure.string/trim)
       (map parse-event)
       sort-events))

(defn sort-events
  [events]
  (sort-by :date t/before? events))


(def test-data
  "[1518-11-01 00:00] Guard #10 begins shift
  [1518-11-01 00:05] falls asleep
  [1518-11-01 00:25] wakes up
  [1518-11-01 00:30] falls asleep
  [1518-11-01 00:55] wakes up
  [1518-11-01 23:58] Guard #99 begins shift
  [1518-11-02 00:40] falls asleep
  [1518-11-02 00:50] wakes up
  [1518-11-03 00:05] Guard #10 begins shift
  [1518-11-03 00:24] falls asleep
  [1518-11-03 00:29] wakes up
  [1518-11-04 00:02] Guard #99 begins shift
  [1518-11-04 00:36] falls asleep
  [1518-11-04 00:46] wakes up
  [1518-11-05 00:03] Guard #99 begins shift
  [1518-11-05 00:45] falls asleep
  [1518-11-05 00:55] wakes up")


(defn get-guard
  [guard-event]
  (re-find #"\d+" (:event guard-event)))

(defn parse-interval
  [asleep awake]
  (t/in-minutes (t/interval (:date asleep) (:date awake))))

(defn parse-minute
  [{:keys [date]}]
  (t/minute date))

(defn parse-sleep
  [[asleep awake]]
  {:sleep-start (parse-minute asleep) :sleep-interval (parse-interval asleep awake)})

(defn parse-shifts
  [[[guard-event] shift-events]]
  {:guard (get-guard guard-event)
   :sleep-events (map parse-sleep (partition 2 shift-events))})


(defn partition-into-shifts
  [events]
  (->> (partition-by #(clojure.string/starts-with? (:event %) "Guard") events)
       (partition 2)
       (map parse-shifts)))


(defn update-minutes-slept-per-guard
  [coll {:keys [guard sleep-events]}]
  (let [minutes-slept (apply + (map :sleep-interval sleep-events))]
    (update coll guard (fnil (partial + minutes-slept) 0))))


(defn add-sleep-events
  [{:keys [sleep-start sleep-interval] :as event} schedule]
  (concat (take sleep-start schedule)
          (doall (map inc (take sleep-interval (drop sleep-start schedule))))
          (drop (+ sleep-start sleep-interval) schedule)))

(defn update-overlap-of-sleep-per-guard
  [coll {:keys [guard sleep-events]}]
  (reduce #(update % guard (fnil (partial add-sleep-events %2) (repeat 60 0))) coll sleep-events))

(defn find-overlap-of-sleep-per-guard
  [shifts]
  (reduce update-overlap-of-sleep-per-guard {} shifts))

(defn find-longest-sleeper
  [overlap-of-sleep-per-guard]
  (apply max-key val (apply merge (map (fn [[k v]] {k (apply + v)}) overlap-of-sleep-per-guard))))

(defn get-most-slept-minute
  [overlap-of-sleep]
  (let [max-val (apply max overlap-of-sleep)]
    {:minute (.indexOf overlap-of-sleep max-val)
     :amount max-val}))

(def get-overlap-of-sleep-per-guard
  (comp find-overlap-of-sleep-per-guard partition-into-shifts parse-events))

(defn part1
  [input]
  (let [overlap-of-sleep-per-guard (get-overlap-of-sleep-per-guard input)
        longest-sleeper (first (find-longest-sleeper overlap-of-sleep-per-guard))]
    overlap-of-sleep-per-guard
    {:longest-sleeper longest-sleeper
     :most-slept-minute (get-most-slept-minute (get overlap-of-sleep-per-guard longest-sleeper))}))


(defn part2
  [input]
  (let [overlap-of-sleep-per-guard (get-overlap-of-sleep-per-guard input)
        most-slept-minutes-per-guard (apply merge
                                            (map (fn [[k v]]
                                                   {k (get-most-slept-minute v)}) overlap-of-sleep-per-guard))]
    (apply max-key (fn [[k {:keys [amount]}]]
                     amount) most-slept-minutes-per-guard)))
