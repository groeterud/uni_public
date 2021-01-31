usorert=[12,3,5,6,7723,23,4,6,0]


length_list=len(usorert)


def length_of_list(list_a):
    length=0
    for i in list_a:
        length+=1

    return length

length_of_list_func=length_of_list(usorert)



print(length_list)
print(length_of_list_func)