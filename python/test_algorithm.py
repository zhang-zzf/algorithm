import unittest as ut
from algorithm import binary_search
from algorithm import selection_sort
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
