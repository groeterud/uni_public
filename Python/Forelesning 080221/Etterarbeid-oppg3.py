def bubble_sort2d_list(liste,cond):
    i=0
    while i !=len(liste):
        for n in range(0,(len(liste)-1)-i):  
            if liste[n][cond]>=liste[n+1][cond]:
                storste_tall=liste[n]
                liste[n]=liste[n+1]
                liste[n+1]=storste_tall
        i+=1
    
    return(liste)

vare=[]
print(vare)

varefil=open('Varer.txt','r',encoding='utf-8')
vnr=varefil.readline()

while vnr!='':
    vnr=vnr.rstrip('\n')
    betegnelse=varefil.readline().rstrip('\n)')
    kategori=varefil.readline().rstrip('\n)')
    hylle=varefil.readline().rstrip('\n)')
    vare+=[[vnr,betegnelse,kategori,hylle]]
    vnr=varefil.readline()

varefil.close()


#første parameter = listevariabel, andre parameter, kolonneverdi som skal sorteres etter. 
vare=bubble_sort2d_list(vare,1)
print(vare)

