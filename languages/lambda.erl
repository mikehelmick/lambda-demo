% An Erlang example of lambdas
%
% c(lambda).
%
% List = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10].
% lists:map(fun lambda:doubleIt/1, List).
%

-module(lambda).
-compile(export_all).

doubleIt(X) -> X * 2.
