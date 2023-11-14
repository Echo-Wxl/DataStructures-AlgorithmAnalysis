"""
数组实现栈
"""


class MyStackArray:
    _the_size = None
    _the_item = list()

    def __init__(self):
        self.do_clear()

    @property
    def size(self):
        return self._the_size + 1

    def do_clear(self):
        self._the_size = -1

    def push(self, new_val):
        self._the_size += 1
        self._the_item[self._the_size] = new_val

    def pop(self):
        if len(self._the_item) == 0:
            raise IndexError("empty stack")

        item = self._the_item[self._the_size]
        self._the_size -= 1
        return item

    def top(self):
        if len(self._the_item) == 0:
            raise IndexError("empty stack")
        return self._the_item[self._the_size]



