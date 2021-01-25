#usortert=[5,4,3,2,1]
#usortert=[40.3, 55.0, 45.7, 43.3, 50.3, 45.9, 53.5, 43.0, 44.2, 44.0, 47.4, 44.0, 33.6, 55.1, 48.8, 50.4, 37.8, 60.3, 46.6]
usortert=list(range(750,0,-1))

print('Lista før sortering er:      ',usortert)
print()
print()

storste_tall=0
i=0
total=0


while i !=len(usortert):
    for n in range(0,(len(usortert)-1)-i):   #kudos til @terje for den -i'en der asså! 
        if usortert[n]>=usortert[n+1]:
            storste_tall=usortert[n]
            usortert[n]=usortert[n+1]
            usortert[n+1]=storste_tall
        total+=1
    i+=1
    total+=1
    
print('Den sorterte listen er:',usortert)
print('Algoritmen er kjørt',i,'ganger')
print('Antall operasjoner er:',total)