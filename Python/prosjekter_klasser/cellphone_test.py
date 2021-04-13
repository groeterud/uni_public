from cellphone import Cellphone

def main():
    man = input('Enter manufacturer ')
    mod = input('Enter model ')
    retail = float(input('Enter the retail price '))

    phone=Cellphone(man,mod,retail)

    print('\n \t Receipt\n')
    print('Manufacturer:\t',phone.get_manufact())
    print('Model number:\t',phone.get_model())
    print('Retail Price:\t',format(phone.get_retail_price(), ',.2f'), sep='')

main()