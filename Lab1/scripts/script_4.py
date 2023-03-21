#!/usr/bin/env python3

import matplotlib.pyplot as plt
import numpy as np

datafiles = ["out_data/out4_1.txt", "out_data/out4_2.txt", "out_data/out4_3.txt", "out_data/out4_4.txt"]

cm = 1/2.54
fig = plt.figure(figsize=(18*cm, 10*cm))
ax = fig.add_subplot(111)
ax.grid()
colors=["red","blue","green","purple"]

ax.set_title('Mean time to recovery (N = 1000, λ = 10^-3 1/hours, m = 1)')
ax.set_xlabel('Number n of elementary machines in base subsystem')
ax.set_ylabel('Mean time to recovery (hours)')

ax.set_xticks([900, 910, 920, 930, 940, 950, 960, 970, 980, 990, 1000])
label=["μ = 1 1/hours", "μ = 2 1/hours", "μ = 4 1/hours", "μ = 6 1/hours"]

for i in range(len(datafiles)):
    data = np.loadtxt(datafiles[i])
    x = data[:, 0]
    y = data[:, 1]
    ax.plot(x,y,'o-',markersize=2,c=colors[i], label = label[i])
plt.legend()
plt.yscale("log");
plt.ylim((0, 40));

fig.savefig('Тau_μ.png', dpi=1000)