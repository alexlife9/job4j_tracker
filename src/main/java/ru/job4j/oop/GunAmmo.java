/*package ru.job4j.oop;

abstract public class GunAmmo {
    Gun gun;

    public String type();

    public static Ammo(Gun someGun, String type) {
        gun = someGun;
        this.type = type;
    }
}*/

/*
Агрегация.
Теперь сделаем снаряды – это наиболее очевидный случай для применения наследования,
но и агрегацию в нем тоже применим. Любой снаряд имеет свои особенности.
Просто неких гипотетических снарядов не бывает. Поэтому класс делаем абстрактным.
Делаем ему строковое поле «тип».

Снаряды делают для пушек. Для определенных пушек.
Снаряд одного калибра не выстрелит из пушки другого калибра.
Поэтому добавляем снаряду поле-ссылку на экземпляр пушки. Делаем конструктор.

Здесь мы применили агрегацию. Где-то будет создана пушка.
Потом к этой пушке будут создаваться снаряды, которые имеют указатель на пушку.
*/