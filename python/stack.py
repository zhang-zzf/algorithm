class Stack():
    def __init__(self):
        self.data = []
        self.top = -1
    
    def push(self, e):
        self.top += 1
        self.data.append(e)
     
    def poll(self):
        if (not self._is_empty()):
            self.top -= 1
            return self.data.pop()
        else:
            return None
    
    def size(self):
        return self.top + 1

    def _is_empty(self):
        return self.top == -1
   
