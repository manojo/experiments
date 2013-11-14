<?
// extract payload from messages
foreach(glob('tweet*') as $f) {
  $d=explode("\n\n",file_get_contents($f));
  file_put_contents('just_'.$f,$d[1]);
  echo '.';
}
echo "\n";
?>