def dobbel_verdi(tallverdi_inn,antall_ganger):
    dobbel=tallverdi_inn*antall_ganger
    return(dobbel)
        
def main():
    tall=int(input('Oppgi tall: '))
    tall=dobbel_verdi(tall,3)
    print(tall)

main()