aar = int(input("hvor magne år er bilen: "))
pris= int(input("hvor mye kostet bilen ny: "))

rentesatser = [20,14,13,12,11,10]
sum_tap =0
for x in range(0,aar,1):
    if x>=len(rentesatser):
        nedgang = pris * (rentesatser[x] / 100)
    else:
        nedgang = pris * (rentesatser[-1]/100)
    
    pris = nedgang - pris
    sum_tap+=nedgang
    


