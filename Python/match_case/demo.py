for x in range(10):
    match x: 
        case 2:
            print("Den er 2")
        case 5:
            print("Den er 5")
        case _:
            print(f"Den er {x}")