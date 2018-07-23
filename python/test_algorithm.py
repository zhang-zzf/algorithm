import unittest as ut
from algorithm import binary_search

class Algorithm(ut.TestCase):

    def test_binary_search(self):
        sorted_list = [1,3,5,7,9]

        index = binary_search(sorted_list, 1)
        self.assertEqual(0, index)

        index = binary_search(sorted_list, 7)
        self.assertEqual(3, index)
        
        index = binary_search(sorted_list, 10)
        self.assertEqual(None, index)