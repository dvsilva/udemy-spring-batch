process() {
	item=$1
	echo $item >${item}.txt
}

process $1
