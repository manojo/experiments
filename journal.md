journal
=======

A log of thoughts which pop up and cannot (yet) be put into code form.

#### 26.07

The Java/C http parser is more or less an inlining of regexes,
with some "event-based" callbacks to deal with the beginning/end
of parsing. These callbacks can return error messages which will
stop the parsing completely.
One idea to deal with this functionally is to use some sort of
continuations.