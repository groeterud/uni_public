from BilDeling import Bil
from lesTextFil import LesTextFil
import pickle

#fil=LesTextFil('Bil.txt',numrows=5)
filer=[]
for x in range(0,1):
    if x ==0:
        fil=LesTextFil('Bil.txt',5)
        filer+=[fil]
    elif x==1:
        fil=LesTextFil('Kunde.txt',4)
        filer+=[fil]

for fil in filer:
    print(fil.file_to_2d_list())


biler=filer[0].file_to_2d_list()

output=open('biler.dat','wb')

for x in range(len(biler)):
    pickle.dump(biler[x],output)
    print('Dumped:\t',biler[x])

output.close()

