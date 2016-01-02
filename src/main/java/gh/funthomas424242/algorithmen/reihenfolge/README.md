==Einsatzzweck==
* Sicherstellung von Reihenfolgen zur Compilezeit

== Erläuterung des Beispiels ==
* Es wird davon ausgegangen, dass eine Klasse Command zunächst validiert werden muss bevor das
Kommando selbst ausgeführt werden kann. 
* Fehlerhafte Verwendungen in der Reihenfolge sollen bereits zur Compilezeit ermittelt werden.
* Als Lösung werden Generics verwendet - die Lösung ist entnommen aus 
"Kaffeeklatsch 08/2015 ISSN: 1865-682X" S. 11 ff.

 