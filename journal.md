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
Answer: the `into` function on Parsers goes quite a long
way to achieve this :-)

#### 10.07

Todo: parsing a header in the java version very quickly gets into the
most relevant state based on characters already seen. The parser combinator
way is to parse the whole line and then check what the name is. For the length
of the line in question, don't think it will make a huge difference either way,
but to keep in mind for testing.

#### 15.07

To be determined: If we parse a content length X > remaining content, do we wait
for further data? Or is it a failure?

A chunk header is a hex number followed possibly by other chars which should
be ignored. Is there a buffer overflow attack check to be done here?

There is a need for a ~ operator that does not skip whitespace. The problem is
that the whiteSpace skipping is managed by the reader, not by the Parsers trait.

The schema parser in the hand-written version does not confirm to the RFC standard
for URIs (http://en.wikipedia.org/wiki/URI_scheme). For now, transliterating the
hand-written version more-or-less loyally.

#### 16.07

Apparently, the hand-written version does not support sip urls as follows:
 - sip:alice@atlanta.com?subject=project%20x&priority=urgent

#### 17.07

The alternation combinator in LMS parsers should be reworked. As for
the moment we do not have Success or Failure classes, should we just
use the position as a measure of success? in that case we need to
find a way to do `guard` or `peek`.

Noticed that structs have changed in LMS. Will need to reintegrate that with Parsers at some point.

#### 18.07

Need to think about fusing the `rep(p){xs => xs.fold}`. `xs` is a
List produced at runtime, and we do not want to produce a
Generator. An alternative is to have a repFold combinator, but it
seems a rather common pattern, so might be useful to fuse it.

Maybe is it good to have repFold as the more general version?

#### 26.07

Using TupleOps from the delite-develop branch, which uses structs internally.
Reminder: reason it is not in the main branch is because it does not play well
with compile (if the input or return type is a tuple)