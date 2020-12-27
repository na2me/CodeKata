package com.code_kata.karate_chop

class KarateChop {
    companion object {
        // int value returned when targetNum is not found
        private const val NOT_FOUND = -1

        /**
         * chop a list by binary search with iterating
         */
        fun iteratorChop(targetNum: Int, list: List<Int>): Int {
            var low = 0
            var high = list.lastIndex

            while (low <= high) {
                val mid = (low + high).ushr(1)
                val midVal = list[mid]
                val cmp = compareValues(midVal, targetNum)

                if (cmp < 0)
                    low = mid + 1
                else if (cmp > 0)
                    high = mid - 1
                else
                    return mid
            }
            return NOT_FOUND
        }

        /**
         * chop a list by binary search recursively
         */
        fun recursiveChop(targetNum: Int, list: List<Int>, offsetIndex: Int = 0): Int {
            var low = 0
            var high = list.lastIndex

            if (list.isEmpty()) return NOT_FOUND

            val mid = (low + high).ushr(1)
            val midVal = list[mid]
            val cmp = compareValues(midVal, targetNum)

            if (cmp < 0) {
                low = mid + 1
                return recursiveChop(targetNum, list.slice(low..list.lastIndex), offsetIndex.plus(low))
            }
            else if (cmp > 0) {
                high = mid - 1
                return recursiveChop(targetNum, list.slice(0 .. high))
            }

            return mid.plus(offsetIndex)
        }

        /**
         * chop a list by library binary search function
         */
        fun libraryChop(targetNum: Int, list: List<Int>): Int {
            val result =  list.binarySearch(targetNum)
            if (result < 0) return NOT_FOUND
            return result
        }
    }
}