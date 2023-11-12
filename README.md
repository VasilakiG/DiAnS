# Дизајн и архитектура на софтвер [F18L3W009](https://finki.ukim.mk/mk/subject/%D0%B4%D0%B8%D0%B7%D0%B0%D1%98%D0%BD-%D0%B8-%D0%B0%D1%80%D1%85%D0%B8%D1%82%D0%B5%D0%BA%D1%82%D1%83%D1%80%D0%B0-%D0%BD%D0%B0-%D1%81%D0%BE%D1%84%D1%82%D0%B2%D0%B5%D1%80)
Веб апликација [MacedoniaTimeless] дизајнирана за мапирање на податоци со отворен код и пронаоѓање на оптимални рути, за културно-историски објекти во Македонија. Изработена како дел од факултетски курс.

## Нашиот тим
Василаки Ѓорѓиоски - 211101 <br />
Виктор Бебек - 211202 <br />
Сара Апостоловска - 211086<br />
Марко Коскоски - 211077<br />

## Краток опис на проектот
Културно-историското наследство на Република Македонија е богато и разновидно, со многу различни историски и културни објекти. Тоа е одраз на вековните историски, културни и етнички влијанија во оваа област. Во Република Македонија се наоѓаат многу значајни објекти и локации кои сведочат за нејзината богатата историја и култура како што се многу национални музеи, ареолошки наоѓалишта, културни објекти и споменици,  верски објекти, потоа различните традиции и обичаи, богат и разновиден фолклор, историски настани, манифестации итн. Ова се само неколку од аспектите на културно - историско наследство на Република Македонија, кое претставува важен дел од идентитетот и културата на земјата.

Со цел да ги промовираме и чуваме овие национални богатства, развиваме веб апликација за мапирање и навигација на културно-историското наследство во нашата земја. Оваа апликација ќе им овозможи на корисниците да истражуваат и да добијат информации за културните и историски објекти но и настани поврзани со нив на територијата на Република Македонија. Корисниците ќе можат да прегледуваат интерактивни мапи, да пребаруваат објекти или настани според интерес, име, географска локација или временски период, а потоа за избраниот објект  да пристапат до информациите поврзани за него. Дополнително ќе можат да креираат листи од омилени објекти, да споделуваат содржини, да оставаат коментари и рецензии како и резервираат поединечни и групни посети. Исто така апликацијата ќе нуди можност за добивање на инструкции за навигација и исцртување на рута од локацијата на корисникот до избраниот објект.

Нашата апликација има за цел да го популаризира и збогати историското и културното наследство на Република Македонија и да им овозможи на корисниците интересен и ефикасен начин на истражување и пристап до богата историја и култура на нашата држава и народ.

## Спецификација на софтверски барања
> Кратка верзија на СРС документ.
> Во прилог се функциските и нефункциските барања на системот, вклучително и нивните приоритети и скалабилност.

Дескрипција на приоритетни нивоа:

![image](https://github.com/VasilakiG/DiAnS/assets/102933065/38712e05-70b1-4507-a77d-9556dcd0e528)


### Функционални барања
1.	Системот треба да им овозможи на корисниците регистрација на свои профили. (приоритет 1)
2.	Системот треба да им овозможи на корисниците најава на системот. (приоритет 1)
3.	Системот треба да им овозможи на корисниците да можат да прегледуваат листа на различни објекти на културно-историско наследство во Република Македонија. (приоритет 1)
4.	Системот треба да има овозможи фукционалност за сортирање според конкретна категорија. (приоритет 1) 
5.	Системот треба да има овозможи фукционалност за филтрирање според конкретна категорија. (приоритет 1) 
6.	Системот треба да има овозможи фукционалност за пребарување според конкретна категорија. (приоритет 1) 
7.	Системот треба да има функционалност за сортирање, филтрирање и пребарување според името на културно-историскот објект. (приоритет 1)
8.	Системот треба да има функционалност за сортирање, филтрирање и пребарување според локацијата во кое се наоѓа културно-историскот објект. (приоритет 1)
9.	Системот треба да има функционалност за сортирање, филтрирање и пребарување според годината на изградба на културно-историскот објект. (приоритет 1)
10.	Системот треба да има функционалност за сортирање, филтрирање и пребарување според типот на културно-историскот објект. (приоритет 1)
11.	Системот треба да овозможи избор на културно-историскот објект од листата. (приоритет 1)
12.	Системот треба да овозможи приказ на детали во врска со избран културно-историски објект. (приоритет 1)
13.	Системот треба да овозможи приказ на детали кои вклучуваат име, слики, видео, опис, локација, контакт информации и историски информации за самиот објект. (приоритет 1)
14.	Системот треба да има можност за приказ на сите објекти на културно-историско наследство на мапа. (приоритет 1)
15.	Системот треба да му овозможи на корисникот пребарување на објекти од интерес на мапата. (приоритет 1)
16.	Системот треба да му овозможи на корисникот селектирање на објект од интерес на мапата. (приоритет 1)
17.	Системот треба да овозможи приказ на инструкции за навигација од локацијата на корисникот до избраниот објект. (приоритет 1)
18.	Системот треба да овозможи приказ на исцртана рута ја од локацијата на корисникот до избраниот објект. (приоритет 1)
19.	Системот треба да овозможи пребарување на локации според клучни зборови. (приоритет 1)
20.	Системот треба да овозможи прикажување на локаци на мапата на објектите на културно-историско наследство филтрирани според внесените критериуми. (приоритет 1)
21.	Системот треба да има можност за давање препораки за објекти на културно-историско наследство во согласност со преференците на даден корисник. (приоритет 2)
22.	Системот треба да има можност за давање препораки за објекти на културно-историско наследство во согласност со историјата на пребарување на даден корисник. (приоритет 2)
23.	Системот треба да им овозможи на корисниците да ја користат GPS локацијата на нивните мобилни уреди за автоматско наоѓање на најблиските објекти на културно-историско наследство. (приоритет 1)
24.	Системот треба да има можност да ја превземе локацијата на корисникот, со негова дозвола. (приоритет 1)
25.	Системот треба да вклучува отворени податоци за објектите на културно-историско наследство од OpenStreetMap на постоечки ресурси за вакви објекти. (приоритет 1)
26.	Системот треба да вклучува отворени податоци за објектите на културно-историско наследство од  API (Application Programing Interface) на постоечки ресурси за вакви објекти. (приоритет 1)
27.	Во системот треба да постои можност корисниците да прават "виртуелни тури" низ културно-историските објекти.
28.	Системот треба да им овозможи на корисниците да ги разгледаат просториите на избраниот објект пред да го посетат преку т.н "виртуелни тури . (приоритет 2)
29.	Системот треба да обезбеди опции за резервации за поединечни посети на објекти на културно-историско наследство. (приоритет 2)
30.	Системот треба да обезбеди опции за резервации за групни посети на објекти на културно-историско наследство. (приоритет 2)
31.	Системот треба да обезбеди опција за нарачка на сувенири од одреден објект преку апликацијата. (приоритет 2)
32.	Системот треба да им овозможи на корисниците да споделуваат содржини од апликацијата на социјални мрежи.(приоритет 2)
33.	Системот треба да им овозможи на корисниците да споделуваат содржини од апликацијата преку е-пошта. (приоритет 2)
34.	Системот треба да интегрира мејл клиент преку кој регистрираните корисници ќе добиваат известувања за идните настани во објектите на културно-историско наследство. (приоритет 2)
35.	Системот треба да им овозможи на корисниците да ги оценуваат објектите на културно-историско наследство со оценка од 1 до 5. (приоритет 1)
36.	Во системот треба да има можност корисниците  да напишат коментари за различни објекти на културно-историско наследство. (приоритет 1)
37.	Системот треба да им овозможи на корисниците да можат да пишуваат детални рецензии за нивните лични искуства при посета на објектите на културно-историско наследство. (приоритет 1)
38.	Системот треба да овозможи преглед на оценките на другите корисници и посетители. (приоритет 2)
39.	Системот треба да овозможи преглед на коментарите на другите корисници и посетители. (приоритет 2)
40.	Системот треба да им овозможи на корисниците додавање на културно-историските објекти во листа на омилени. (приоритет 1)
41.	Системот треба да има можност за креирање на кориснички профил со улога на администратор. (приоритет 1)
42.	Системот треба да му овозможи на администраторот да ги ажурира податоците за објектите на културно-историско наследство и да додава или брише вакви објекти. (приоритет 1)
43.	Системот треба да му овозможи на администраторот да ги брише коментарите. (приоритет 2)
44.	Системот треба да му овозможи на администраторот да ги брише рецензиите од корисниците. (приоритет 2)
45.	Системот треба да му овозможи на администраторот пристап до статистички извештаи за употребата на апликацијата. (приоритет 2)
46.	Системот треба да му овозможи на администраторот пристап до активностите на корисниците односно најчести пребарувања. (приоритет 2) 

### Нефункционални барања
1.	Системот треба да има достапна јазична подршка на македонски, албански и англиски јазик за подобар пристап на корисниците и туристите. (приоритет 1)
2.	Системот треба да е достапен за употреба во повеќе од 99% од времето. (приоритет 1)
3.	Системот треба да нуди кориснички интерфејс кој е интуитивен и едноставен за употреба. (приоритет 1)
4.	Корисничкиот интерфејс на системот треба да биде прилагодлив на мобилни уреди. (приоритет 1)
5.	Корисничкиот интерфејс на системот треба да биде прилагодлив на десктоп уреди. (приоритет 1)
6.	Системот треба да обезбеди подршка за најмногу 100 корисници одеднаш. (приоритет 1)
7.	Системот треба да има можности за заштита на приватноста на корисниците. (приоритет 1)
8.	Системот треба да има можност за сигурно чување на личните податоци на корисниците според важечките законски прописи. (приоритет 1)
9.	Системот треба да може да прима 100  HTTP барања во секунда. (приоритет 1)
10.	Системот мора да има достапна претходна стабилна верзија за време на надградувањето на истиот. (прироритет 2)
11.	Системот треба до овозможи листа за брза навигација. (приоритет 3)
12.	Системот треба да биде достапен за сите веб прелистувачи. (приоритет 1)
13.	Системот треба да биде скалабилен и да поддржува раст на бројот на културни објекти. (приоритет 1)
14.	Системот треба да биде скалабилен и да поддржува раст на бројот на корисници. (приоритет 1)
15.	Просечното време за одговор на системот треба да биде 2 секунди. (приоритет 1)
16.	Зависноста на системската имплементација од одреден оперативен систем не треба да надминува 5%. (приоритет 1)
17.	Времето на неактивност при ажурирање на апликацијата да биде минимално. (приоритет 1)
18.	Во системот треба да се импламентирани мерки за заштита од различни видови напади. (приоритет 1)


## License
[MIT License](LICENSE)
