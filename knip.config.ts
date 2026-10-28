import type { KnipConfig } from 'knip'

const config: KnipConfig = {
  ignore: [
    'frontend/src/components/ui/**',
    'frontend/src/components/layout/app-title.tsx',
    'frontend/src/tanstack-table.d.ts',
  ],
}

export default config