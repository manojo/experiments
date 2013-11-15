<?


function dump_req($url,$file) {
  $f=fsockopen('127.0.0.1',80);
  fputs($f,"GET ".$url." HTTP/1.1\r\nHost: localhost\r\nConnection: close\r\n\r\n");
  $d=''; while (!feof($f)) { $d.=fgets($f); } fclose($f); file_put_contents($file,$d);
}

@mkdir('chunked');
dump_req('/chunked.php','chunked/bulk');
for ($i=1;$i<=101;++$i) {
  dump_req('/chunked.php?id='.$i,'chunked/msg'.$i);
}

/*
$f=fsockopen('127.0.0.1',80);
fputs($f,"GET /bulk.php HTTP/1.1\r\nHost: localhost\r\nConnection: close\r\n\r\n");
$d='';
while (!feof($f)) { $d.=fgets($f); }
fclose($f);
file_put_contents('bulk_http',$d);





for ($i=1;$i<=101;++$i) {
  $f=fsockopen('127.0.0.1',80);
  fputs($f,"GET /chunked.php?id='.$i.' HTTP/1.1\r\nHost: localhost\r\nConnection: close\r\n\r\n");
  $d='';
  while (!feof($f)) { $d.=fgets($f); }
  fclose($f);
  file_put_contents('chunked/chunked'.$i,$d);
}
*/
?>