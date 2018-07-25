import unittest as ut
from algorithm import binary_search
from algorithm import recursion_binary_search
from algorithm import selection_sort
from algorithm import factorial
from algorithm import factorial2
from algorithm import recursion_sum
from algorithm import recursion_sum2
from algorithm import recursion_max_value
from algorithm import recursion_quick_sort
from algorithm import quick_sort

class AlgorithmTestCase(ut.TestCase):

    def test_binary_search(self):
        sorted_list = [1, 3, 5, 7, 9]

        index = binary_search(sorted_list, 1)
        self.assertEqual(0, index)

        index = binary_search(sorted_list, 7)
        self.assertEqual(3, index)

        index = binary_search(sorted_list, 10)
        self.assertEqual(None, index)

    def test_selection_sort(self):
        list = [1, 5, 9, 7, 11, 55]

        selection_sort(list)
        self.assertListEqual([55, 11, 9, 7, 5, 1], list)

    def test_factorial(self):
        self.assertEqual(120, factorial(5))
        self.assertFalse(120 == factorial(4))

    def test_factorial2(self):
        self.assertEqual(24, factorial2(4))

    def test_recursion_sum(self):
        array = []
        self.assertEqual(0, recursion_sum(array))

        array = [1]
        self.assertEqual(1, recursion_sum(array))

        array = [1,2,3,4,5]
        self.assertEqual(15, recursion_sum2(array, 0, len(array)))

    def test_recursion_sum2(self):
        array = []
        self.assertEqual(0, recursion_sum2(array, 0, len(array)))

        array = [1]
        self.assertEqual(1, recursion_sum2(array, 0, len(array)))

        array = [1,2,3,4,5]
        self.assertEqual(15, recursion_sum2(array, 0, len(array)))

        array = [1,2,3,4,5]
        self.assertEqual(9, recursion_sum2(array, len(array) - 2, len(array)))
    
    def test_recursion_max_value(self):
        array = []
        self.assertEqual(None, recursion_max_value(array))

        array = [5]
        self.assertEqual(5, recursion_max_value(array, 0, len(array)))

        array = [5, 4, 1, 11]
        self.assertEqual(11, recursion_max_value(array, 0, len(array)))

    def test_recursion_binary_search(self):
        sorted_list = [1, 3, 5, 7, 9]
        for index in range(len(sorted_list)):
            self.assertEqual(index, recursion_binary_search(sorted_list, sorted_list[index], 0, len(sorted_list)))

        self.assertEqual(None, recursion_binary_search(sorted_list, -1, 0, len(sorted_list)))
        self.assertEqual(None, recursion_binary_search(sorted_list, 10, 0, len(sorted_list)))

    def test_recursion_quick_sort(self):
        lst = [1, 3, 11, 8, -1, 100, -50, 99, 0, 33]
        sorted_lst = [-50, -1, 0, 1, 3, 8, 11, 33, 99, 100]
        recursion_quick_sort(lst, 0, len(lst))
        self.assertListEqual(sorted_lst,lst)

    def test_quick_sort(self):
        lst = [1, 3, 11, 8, -1, 100, -50, 99, 0, 33]
        sorted_lst = [-50, -1, 0, 1, 3, 8, 11, 33, 99, 100]
        quick_sort(lst, 0, len(lst))
        self.assertListEqual(sorted_lst,lst)
