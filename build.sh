#!/bin/bash
for theme in AnnArbor Antibes Bergen Berkeley Berlin Boadilla CambridgeUS Copenhagen Darmstadt Dresden Frankfurt Goettingen Hannover Ilmenau JuanLesPins Luebeck Madrid Malmoe Marburg Montpellier PaloAlto Pittsburgh Rochester Singapore Szeged Warsaw ; do 
	sed "s/%%%%%THEME_PLACEHOLDER_JENKINSBUILD%%%%%/\\\usetheme{$theme}/g" mocking.tex > mocking-$theme.tex; pdflatex --halt-on-error "mocking-$theme.tex"; pdflatex --halt-on-error "mocking-$theme.tex"; done;

exit 0
