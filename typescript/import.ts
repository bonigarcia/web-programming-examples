// import.ts

import {square, cow} from './export';
console.log(square(2));
cow();

import {square as sqr} from './utils';
sqr(2);

import * as utils from './utils';
console.log(utils.square(2));
utils.cow();

