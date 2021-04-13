from cellphone import Cellphone

def main():
    phones=make_list()

    print("Here's the data you entered")
    display_list(phones)



def make_list():
    phone_list=[]

    #add 5 phones
    for count in range(1,6):
        print('Phone number '+str(count)+":")
        man=input('Enter Manufacturer: ')
        mod=input('Enter Model: ')
        ret=float(input('Enter Retail Price: '))
        print()

        phone=Cellphone(man,mod,ret)

        phone_list.append(phone)
    
    return phone_list

def display_list(phone_list:list):
    for item in phone_list:
        print(item.get_manufact())
        print(item.get_model())
        print(item.get_retail_price())
        print()        

main()