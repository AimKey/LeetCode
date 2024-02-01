

from typing import Optional

from httpx import head
        
# Definition for singly-linked list.
# We can concat them and sort
# Or we sort as we concat ?
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
        
class Solution:
    def traverse(self, headNode: Optional[ListNode]):
        while (headNode is not None):
            print(headNode.val, end=" ")
            headNode = headNode.next
        print()
    
    def bubbleSort(self, headNode: Optional[ListNode]):
        tempNode = headNode
        while (tempNode is not None):
            curNode = headNode
            while (curNode is not None and curNode.next is not None):
                if (curNode.val > curNode.next.val):
                    temp = curNode.next.val
                    curNode.next.val = curNode.val
                    curNode.val = temp
                curNode = curNode.next
            tempNode = tempNode.next
        return headNode
                    
            
    
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if (list1 is None and list2 is None):
            return None
        elif (list1 is None and list2 is not None):
            return list2
        elif (list1 is not None and list2 is None):
            return list1
        else:
            # Get the last node of list1
            if list1 is not None:
                currentNode = list1
            while currentNode.next is not None:
                currentNode = currentNode.next
                
            if currentNode is not None:
                currentNode.next = list2
                self.bubbleSort(list1) 
            return list1
  

            
solution = Solution()
list1 = ListNode(-2, ListNode(5, ListNode(-9, None)))
list2 = ListNode(-6, ListNode(-3, ListNode(-1, None)))
result = solution.mergeTwoLists(list1, list2)
solution.traverse(result)
# traverse(result)