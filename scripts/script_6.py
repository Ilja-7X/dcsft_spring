#!/usr/bin/env python3

import matplotlib.pyplot as plt
import numpy as np

datafiles = ["out_data/out6_1.txt", "out_data/out6_2.txt", "out_data/out6_3.txt", "out_data/out6_4.txt"]

cm = 1/2.54
fig = plt.figure(figsize=(18*cm, 10*cm))
ax = fig.add_subplot(111)
ax.grid()
colors=["red","blue","green","purple"]

ax.set_title('Mean time to recovery (N = 8192,μ = 1 1/hours, λ = 10^-5 1/hours)')
ax.set_xlabel('Number n of elementary machines in base subsystem')
ax.set_ylabel('Mean time to recovery (hours)')

ax.set_xticks([8092, 8102, 8112,8122, 8132, 8142, 8152, 8162, 8172, 8182, 8192])
label=["m = 1", "m = 2", "m = 3", "m = 4"]

for i in range(len(datafiles)):

    data = np.loadtxt(datafiles[i])
    x = data[:, 0]
    y = data[:, 1]
    ax.plot(x,y,'o-',markersize=2,c=colors[i], label = label[i])
plt.legend()
plt.yscale("linear");
plt.ylim((None, 1.4));

fig.savefig('Tau_m.png', dpi=1000)