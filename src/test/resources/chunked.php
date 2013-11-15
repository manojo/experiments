<?

$id=intval(@$_GET['id']);
$base='/Documents/EPFL/MasterProj/experiments/src/test/resources/just_tweet';

function dump($f) {
  $d=str_split(file_get_contents($f),4096);
  foreach($d as $p) { echo $p; ob_flush(); }
}

if ($id>0) { // one file at a time  
  dump($base.$id);
} else { // bulk all
  $f=false;
  foreach(glob($base.'*') as $g) {
    echo $f?',':'['; $f=true;
    dump($g);
  }
  if (!$f) echo '['; echo ']';
}
?>