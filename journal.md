journal
=======

A log of thoughts which pop up and cannot (yet) be put into code form.

#### 26.06

The Java/C http parser is more or less an inlining of regexes,
with some "event-based" callbacks to deal with the beginning/end
of parsing. These callbacks can return error messages which will
stop the parsing completely.
One idea to deal with this functionally is to use some sort of
continuations.

#### 10.07

Todo: parsing a header in the java version very quickly gets into the
most relevant state based on characters already seen. The parser combinator
way is to parse the whole line and then check what the name is. For the length
of the line in question, don't think it will make a huge difference either way,
but to keep in mind for testing.