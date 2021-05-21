from BilDeling import Bil
from lesTextFil import LesTextFil
import pickle

fil=LesTextFil('Bil.txt',5)

biler=fil.file_to_2d_list()

output=open('biler.dat','wb')

for x in range(len(biler)):
    pickle.dump(biler[x],output)
    print('Dumped:\t',biler[x])

output.close()
