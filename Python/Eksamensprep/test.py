def find_uniq(arr):
    # your code here
    
    first=[]
    second=[]
    
    for x in range(len(arr)):
        if x==0:
            first+=[arr[x]]
        else:
            if arr[x]==first[0]:
                first+=[arr[x]]
            else:
                second+=[arr[x]]
        
    
    if len(first)>len(second):
        return second[0]
    else:
        return first[0]
        

find_uniq([1, 1, 1, 2, 1, 1])
    
