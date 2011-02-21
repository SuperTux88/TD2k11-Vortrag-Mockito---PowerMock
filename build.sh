#!/bin/bash
for theme in AnnArbor Antibes Bergen Berkeley Berlin Boadilla CambridgeUS Copenhagen Darmstadt Dresden Frankfurt Goettingen Hannover Ilmenau JuanLesPins Luebeck Madrid Malmoe Marburg Montpellier PaloAlto Pittsburgh Rochester Singapore Szeged Warsaw ; do 
		sed "s/%%%%%THEME_PLACEHOLDER_JENKINSBUILD%%%%%/\\\usetheme{$theme}/g" mocking.tex > "mocking-$theme.tex"; 
		sed "s/%%%%%HANDOUT_PLACEHOLDER_JENKINSBUILD%%%%%/\\\pgfpagesuselayout{4 on 1}[a4paper,border shrink=5mm,landscape]/g" "mocking-$theme.tex" > "mocking-$theme-handout.tex";

		pdflatex --halt-on-error "mocking-$theme.tex"; 
		pdflatex --halt-on-error "mocking-$theme.tex"; 
		pdflatex --halt-on-error "mocking-$theme-handout.tex"; 
		pdflatex --halt-on-error "mocking-$theme-handout.tex"; 
	done;

exit 0
