
 AKADEMIE
Java Akademie
Lekce 5.6: Domácí úkol lekce 5: Pokojové rostliny
100% hotovo
12 / 12 kapitol
ZADÁNÍ A MODEL DAT
Model dat
Připravte třídu pro ukládání informací o pokojových rostlinách (plant).

U každé rostliny budeme mít uložen:
název (name),
poznámky (notes),
datum, kdy byly zasazena (planted),
datum poslední zálivky (watering)
běžnou frekvenci zálivky ve dnech (frequency of watering)
Vytvořte tři konstruktory:
jeden pro nastavení všech atributů
druhý nastaví jako poznámku prázdný řetězec a datum poslední zálivky nastaví na dnešní datum.
třetí nastaví totéž co druhý a navíc výchozí frekvenci zálivky na 7 dnů a datum zasazení na dnešní datum. (Uživatel tedy bude zadávat pouze název rostliny.)
Vytvořte výchozí přístupové metody pro všechny atributy.
Připravte metodu getWateringInfo(), která vrátí název květiny, datum poslední zálivky a datum doporučené další zálivky. (Metoda vrátí textový řetězec, obsahující požadované informace.)
VÝJIMKY
Ošetření nesprávného vstupu
Vytvoř novou třídu výjimek s názvem PlantException. Bude potomkem (extends) třídy Exception.

Ošetři zadávání frekvence zálivky — pokud je parametrem 0 nebo záporné číslo, systém vyhodí výjimku třídy PlantException s vhodným popisem.

Obdobně ošetřete zadávání data poslední zálivky — nesmí být starší než datum zasazení rostliny.

PRÁCE SE SOUBORY
Vytvoření seznamu květin
Vytvoř třídu pro ukládání seznamu pokojových květin. Jako atribut bude mít kolekci, uchovávající objekty s informacemi o květinách. Chceme mít možnost vytvářet více seznamů a jednotlivé seznamy exportovat do souboru či je ze souboru načítat.
Přidej metody pro přidání nové květiny, získání květiny na zadaném indexu a odebrání květiny ze seznamu.
Načtení ze souboru
Přidej do seznamu květin metodu pro načtení květin ze souboru.
V případě chybného vstupu vyhoď výjimku.
Do jednoho souboru se vždy uloží obsah jednoho seznamu květin.
Přidej do seznamu květin metodu pro uložení aktualizovaného seznamu do souboru.
Ověření
Načti seznam květin ze souboru kvetiny.txt.
Soubor si stáhni celý! Při kopírování obsahu IntelliJ nahradí tabulátory za mezery a načtení nebude fungovat správně!

Vypiš na obrazovku informace o zálivce pro všechny květiny.
Přidej dvě nové květiny do seznamu. Jednu květinu odeberte.
Ulož seznam květin do nového souboru a ověřte, že je jeho obsah správný. Výsledný soubor by měl vypadat takto:
Fialka 1 Popis fialky - je fialová a hezká   3   2021-05-12  2021-01-01
Vánoční hvězda bez poznámky      4   2021-05-10  2021-04-01
Bazalka v kuchyni        3   2021-09-04  2021-09-04
Vyzkoušej opětovné načtení vygenerovaného souboru.
ŘAZENÍ SEZNAMU ROSTLIN
Seřaď rostliny podle názvu
Uprav třídu Plant tak, aby bylo možné seznam rostlin řadit podle názvu rostliny pomocí Collections.sort.
V main() seřaď načtené rostliny podle názvu.
Seřaď rostliny podle data poslední zálivky
Uprav kód tak, aby rostliny bylo možno řadit i podle data poslední zálivky.
(Ponech možnost řadit podle názvu stále funkční.)
Proveď v main() druhý výpis, který vypíše rostliny seřazené podle data poslední zálivky.
DOPORUČENÉ OVĚŘENÍ NAVÍC
Poškozený soubor 1
Vyzkoušej, že se aplikace bude chovat správně při načtení vadného souboru kvetiny-spatne-datum.txt.
Soubor si stáhni celý! Při kopírování obsahu IntelliJ nahradí tabulátory za mezery a načtení nebude fungovat správně!

Poškozený soubor 2
Vyzkoušej, že se aplikace bude chovat správně při načtení vadného souboru kvetiny-spatne-frekvence.txt
Soubor si stáhni celý! Při kopírování obsahu IntelliJ nahradí tabulátory za mezery a načtení nebude fungovat správně!

TIPY
Tip: Více konstruktorů ve třídě
Pokud máš v jedné třídě více konstruktorů a některé z nich doplňují výchozí hodnoty atributů, můžeš použít volání druhého konstruktoru pomocí operátoru this.

Výhodné je, že je pak každá výchozí hodnota v kódu uvedena jen jednou.

Tip: Využití konstant
Pokud se na více místech v kódu vyskytuje stejný textový literál, je vhodnější vytvořit konstantu a vhodně ji pojmenovat.

Tip: Speciální třída s konfigurací
Konstanty z více tříd můžeš také dát do jedné společné třídy. Potom je snazší tato nastavení přesunout do konfiguračního souboru či do databáze a vytvořit k nim třeba speciální dialog s nastavením celé aplikace. Jsou totiž všechny pohromadě.

Ukázka kódu3
ZKOPÍROVAT KÓD
public class Settings {
    private static final String FILENAME = "data.txt";
    private static final int MAX_CONNECTIONS = 5;
    public static String filename() { return FILENAME; }
    public static int maxConnections() { return MAX_CONNECTIONS; }
}
Ukázka kódu4
ZKOPÍROVAT KÓD
InputOutput.write(Settings.filename());
Gratulujeme! Máš hotový tento studijní materiál.
ZPĚT DO AKADEMIE