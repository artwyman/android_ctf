#!/usr/bin/env python3

import random

FLAG_VALUE = 'insert_flag_here'
SEED = 0
OFFSET = 17
LENGTH = 50

random.seed(SEED)
rand_bytes = [random.randint(0,255) for _ in range(LENGTH)]
flag_bytes = [random.randint(0,255) for _ in range(LENGTH)]
for i in range(len(FLAG_VALUE)):
    flag_bytes[OFFSET+i] = ord(FLAG_VALUE[i])
flag_bytes[0] = OFFSET
flag_bytes[OFFSET + len(FLAG_VALUE)] = 0

xor_bytes = [rand_bytes[i] ^ flag_bytes[i] for i in range(LENGTH)]


def print_array(name, bytes):
    print('private static final byte[] {} = {{{}}};'.format(
        name,
        ', '.join('(byte)'+hex(b) for b in bytes)))

print_array('BYTES1', rand_bytes)
print_array('BYTES2', xor_bytes)
