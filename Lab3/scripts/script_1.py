#!/usr/bin/env python3

import matplotlib.pyplot as plt
import numpy as np

datafiles = ["out_data/out1_1.txt", "out_data/out1_2.txt", "out_data/out1_3.txt", "out_data/out1_4.txt"]

cm = 1/2.54
fig = plt.figure(figsize=(18*cm, 10*cm))
ax = fig.add_subplot(111)
ax.grid()
colors=["red","blue","green","purple"]

ax.set_title('Mean time between failures (N = 65536, λ = 10^-5 1/hours, m = 1)')
ax.set_xlabel('Number n of elementary machines in base subsystem')
ax.set_ylabel('Mean time between failures (hours)')

ax.set_xticks([65527,65528,65529,65530,65531,65532,65533,65534,65535,65536])
label=["μ = 1 1/hours", "μ = 10 1/hours", "μ = 100 1/hours", "μ = 1000 1/hours"]

for i in range(len(datafiles)):
    data = np.loadtxt(datafiles[i])
    x = data[:, 0]
    y = data[:, 1]
    ax.plot(x,y,'o-',markersize=2,c=colors[i], label = label[i])
plt.legend()
plt.yscale("log");
plt.ylim((1, 1e6));

fig.savefig('Theta_μ.png', dpi=1000)