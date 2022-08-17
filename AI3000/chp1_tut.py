from sklearn import datasets

house_prices = datasets.load_boston()
#print(house_prices.DESCR)
print(house_prices.data.shape)
""" digits = datasets.load_digits()
print(digits.images[4]) """