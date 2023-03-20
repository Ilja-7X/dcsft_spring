#!/usr/bin/env python3

import matplotlib.pyplot as plt
import numpy as np

datafiles = ["out_data/out2_1.txt", "out_data/out2_2.txt", "out_data/out2_3.txt", "out_data/out2_4.txt", "out_data/out2_5.txt"]

cm = 1/2.54
fig = plt.figure(figsize=(18*cm, 10*cm))
ax = fig.add_subplot(111)
ax.grid()
colors=["red","blue","green","purple", "gray"]

ax.set_title('Mean time between failures (N = 65536, μ = 1 1/hours, m = 1)')
ax.set_xlabel('Number n of elementary machines in base subsystem')
ax.set_ylabel('Mean time between failures (hours)')

ax.set_xticks([65527,65528,65529,65530,65531,65532,65533,65534,65535,65536])
label=["λ = 10^-5", "λ = 10^-6", "λ = 10^-7", "λ = 10^-8", "λ = 10^-9"]

for i in range(len(datafiles)):

    data = np.loadtxt(datafiles[i])
    x = data[:, 0]
    y = data[:, 1]
    ax.plot(x,y,'o-',markersize=2,c=colors[i], label = label[i])
plt.legend()
plt.yscale("log");
plt.ylim((None, 1e50));

fig.savefig('Theta_λ.png', dpi=1000)