#usortert=[5,4,3,2,1]
#usortert=[40.3, 55.0, 45.7, 43.3, 50.3, 45.9, 53.5, 43.0, 44.2, 44.0, 47.4, 44.0, 33.6, 55.1, 48.8, 50.4, 37.8, 60.3, 46.6]
usortert=list(range(750,0,-1))

print('Lista før sortering er:      ',usortert)
print()
print()


total=0


for i in range(len(usortert)):
    cursor=usortert[i]
    position=i

    #sjekker om alle foregående posisjoner har mindre verdier enn seleksjonen. 
    while position > 0 and usortert[position-1] > cursor:
        usortert[position] = usortert[position-1]
        position=position-1
        total+=1

    usortert[position]=cursor
    total+=1


print('Den sorterte listen er:',usortert)
print('Algoritmen er kjørt',i,'ganger')
print('Antall operasjoner er:',total)