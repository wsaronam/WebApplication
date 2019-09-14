<?php
	$zip = $_GET["zip"];
	
	// CSV header as keys by starrychloe@oliveyou.net
	$file = "zip_codes.csv";
	$csv = array_map('str_getcsv', file($file));
    array_walk($csv, function(&$a) use ($csv) {
      $a = array_combine($csv[0], $a);
    });
    array_shift($csv); # remove column header
	// Snippet end
	
	// CSV header as keys by starrychloe@oliveyou.net
	$file2 = "tax_rates.csv";
	$csv2 = array_map('str_getcsv', file($file2));
    array_walk($csv2, function(&$a) use ($csv2) {
      $a = array_combine($csv2[0], $a);
    });
    array_shift($csv2); # remove column header
	// Snippet end
	
	if (in_array($zip, array_map(function($v){return $v['zip'];},$csv))) {
		$key = array_search($zip, array_map(function($v){return $v['zip'];},$csv));
	}
	else {
		$key = "";
	}
	if (in_array($zip, array_map(function($v){return $v['ZipCode'];},$csv2))) {
		$key2 = array_search($zip, array_map(function($v){return $v['ZipCode'];},$csv2));
	}
	else {
		$key2 = "";
	}
	echo $csv[$key]['state'].",".$csv[$key]['city'].",".$csv2[$key2]['CombinedRate'];
?>